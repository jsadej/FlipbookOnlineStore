package com.example.flipbook;


import com.example.flipbook.catalog.application.port.CatalogUseCase;
import com.example.flipbook.catalog.domain.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class ApplicationStartUp  implements CommandLineRunner {
    private final CatalogUseCase catalog;
    private  final String title;
   // private final  String author;


    public ApplicationStartUp(CatalogUseCase catalog,
                              @Value("${flipbook.catalog.querry}") String title
                             // @Value("${flipbook.catalog.querryAuthor}") String author
    )


    {
        this.catalog = catalog;
        this.title = title;
       // this.author=author;

    }

    @Override
    public void run(String... args)  {
        findByTitle();
        initData();

    }

    private void initData() {
        catalog.addBook(new CatalogUseCase.CreateBookCommand("Pan Tadeusz","Adam Mickiewicz",1834));
        catalog.addBook(new CatalogUseCase.CreateBookCommand("Ogniem i mieczem","Henryk Sienkiewicz",1883));
        catalog.addBook(new CatalogUseCase.CreateBookCommand("Chłopi","Władysław Remont",1904));
        catalog.addBook(new CatalogUseCase.CreateBookCommand( "Pan Wołodyjowski","Henryk Sienkiewicz",1899));

    }

    private void findByTitle() {
        List<Book> books=catalog.findByTitle(title);
        books.forEach(System.out::println);


    }
}
