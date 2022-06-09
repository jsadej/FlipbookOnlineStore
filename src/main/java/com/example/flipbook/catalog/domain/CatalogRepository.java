package com.example.flipbook.catalog.domain;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository {
    //komunikacja z baza danych
    List<Book> findAll();
    void save(Book book);

    Optional<Book> findByID(Long id);

    void removeById(Long id);
}
