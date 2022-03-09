package com.example.flipbook.catalog.infrastructure;

import com.example.flipbook.catalog.domain.Book;
import com.example.flipbook.catalog.domain.CatalogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Repository
public class MemoryRepository implements CatalogRepository {


    private final Map<Long, Book> storage =new ConcurrentHashMap<>();
    public MemoryRepository() {
        storage.put(1L,new Book(1L,"Pan Tadeusz","Adam Mickiewicz",1834));
        storage.put(2L,new Book(2L,"Ogniem i mieczem","Henryk Sienkiewicz",1883));
        storage.put(3L,new Book(3L,"Chłopi","Władysław Remont",1904));
        storage.put(4L,new Book(4L,"Pan Wołodyjowski","Henryk Sienkiewicz",1899));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(storage.values());
    }
}


