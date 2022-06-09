package com.example.flipbook;


import com.example.flipbook.Order.application.PlaceOrderServices;
import com.example.flipbook.Order.application.QueryOrderServices;
import com.example.flipbook.Order.application.port.PlaceOrderUseCase;
import com.example.flipbook.Order.application.port.PlaceOrderUseCase.PlaceOrderCommand;
import com.example.flipbook.Order.application.port.QueryOrderUseCase;
import com.example.flipbook.Order.domain.OrderItem;
import com.example.flipbook.Order.domain.Recipient;
import com.example.flipbook.catalog.application.port.CatalogUseCase;
import com.example.flipbook.catalog.domain.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

import static com.example.flipbook.Order.application.port.PlaceOrderUseCase.*;

@Component

public class ApplicationStartUp  implements CommandLineRunner {
    private final CatalogUseCase catalog;
   private final PlaceOrderUseCase placeOrder;
    private  final QueryOrderUseCase queryOrder;
    private  final String title;
   // private final  String author;



    public ApplicationStartUp(CatalogUseCase catalog,
                              PlaceOrderUseCase placeOrder,
                              QueryOrderUseCase queryOrder,
                              @Value("${flipbook.catalog.querry}") String title
                             // @Value("${flipbook.catalog.querryAuthor}") String author
    )


    {
        this.catalog = catalog;
        this.title = title;
        this.placeOrder=placeOrder;
        this.queryOrder=queryOrder;
       // this.author=author;

    }

    @Override
    public void run(String... args)  {
        initData();
        searchCatalog();
        placeOrder();

    }

    private void placeOrder() {
        //find pan tadeusz
         Book panTadeusz= catalog.findOneByTitle("Pan Tadeusz").orElseThrow(()->new IllegalCallerException("Can not found a book"));
         // find chlopi
        Book chlopi= catalog.findOneByTitle("Chłopi").orElseThrow(()->new IllegalCallerException("Can not found a book"));
        // create recipient
        Recipient recipient=Recipient.
                builder().
                name("Jan kowaslki").
                phone("509-342-123").
                city("Kielce").
                street("Miodowa 9").
                zipCode("30-609").
                email("kowalski.jan@wp.pl").
                build();
        PlaceOrderCommand command= PlaceOrderCommand
                .builder()
                .recipient(recipient)
                .item(new OrderItem(panTadeusz,16))
                .item(new OrderItem(chlopi,7))
                .build();
     PlaceOrderResponse response =placeOrder.placeOrder(command);
        System.out.println("Created order with Id "+ response.getOrderId());
        queryOrder.findAll()
                .forEach(order -> {
                    System.out.println("Got order with total price "+ order.totalPrice() + " details:" + order);
                });
    }

    private void searchCatalog() {
        findByTitle();
        findAndUpdate();
        findByTitle();
    }

    private void initData() {
        catalog.addBook(new CatalogUseCase.CreateBookCommand("Pan Tadeusz", "Adam Mickiewicz",1834,new BigDecimal("29.99")));
        catalog.addBook(new CatalogUseCase.CreateBookCommand("Ogniem i mieczem","Henryk Sienkiewicz",1883,new BigDecimal("14.99")));
        catalog.addBook(new CatalogUseCase.CreateBookCommand("Chłopi","Władysław Remont",1904,new BigDecimal("21.99")));
        catalog.addBook(new CatalogUseCase.CreateBookCommand( "Pan Wołodyjowski","Henryk Sienkiewicz",1899,new BigDecimal("24.99")));
    }

    private void findByTitle() {
        List<Book> books=catalog.findByTitle(title);
        books.forEach(System.out::println);
    }
    private  void findAndUpdate(){
        System.out.println("Updateing book...");
        catalog.findOneByTitleAndAuthor("Pan Tadeusz","Adam Mickiewicz")
        .ifPresent(book -> {
            CatalogUseCase.UpdateBookCommand command=CatalogUseCase.UpdateBookCommand.builder()
                    .id(book.getId())
                    .title("Pan Tadeusz,czyli Ostatni Zajazd na Litwie")
                    .build();

           catalog.updateBook(command);

        });

    }
}
