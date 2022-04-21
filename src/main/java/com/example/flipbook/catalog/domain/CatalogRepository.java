package com.example.flipbook.catalog.domain;

import java.util.List;

public interface CatalogRepository {
    //komunikacja z baza danych
    List<Book> findAll();
    void save(Book book);

}
