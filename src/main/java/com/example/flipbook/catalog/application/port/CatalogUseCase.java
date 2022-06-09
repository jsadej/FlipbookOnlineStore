package com.example.flipbook.catalog.application.port;

import com.example.flipbook.catalog.domain.Book;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CatalogUseCase {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    List<Book> findByTitle(String title);


    Optional<Book> findOneByAuthor(String author);

    Optional<Book> findOneByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByTitleAndAuthor(String title, String author);

    Optional<Book> findOneByTitleAndAuthor(String title, String author);

    void addBook(CreateBookCommand command);

    void removeById(Long id);

    UpdateBookResponse updateBook(UpdateBookCommand command);
@Value
   class  CreateBookCommand {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    String title;
    String author;
    Integer year;
    BigDecimal price;


     public  Book toBooK(){
      return new Book(title, author, year,price);

     }
}
    @Value
    @Builder
    class  UpdateBookCommand {
        Long id;
        String title;
        String author;
        Integer year;

       public Book updateFields(Book book){
            if(title !=null){
             book.setTitle(title);
            }
            if(author !=null) {
              book.setAuthor(author);
            }
            if(year!=null){
             book.setYear(year);
           }
            return book;
        }   }


    @Value
    class UpdateBookResponse{
     public static UpdateBookResponse SUCCESS=new UpdateBookResponse(true, Collections.emptyList());
     boolean success;
     List<String> errors;
    }
}
