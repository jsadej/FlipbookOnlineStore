package com.example.flipbook.catalog.application.port;

import com.example.flipbook.catalog.domain.Book;
import lombok.Value;

import java.util.List;
import java.util.Optional;

public interface CatalogUseCase {
    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findAll();

    Optional<Book> findOneByTitleAndAuthor(String title, String author);

    void addBook(CreateBookCommand CreateBookCommand);

    void removeById(Long id);

    void updateBook();
    @Value
  class   CreateBookCommand{
        String title;
        String author;
        Integer year;

    }
}
