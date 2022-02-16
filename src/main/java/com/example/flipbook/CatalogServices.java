package com.example.flipbook;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class CatalogServices {
    private final Map<Long,Book> storage =new ConcurrentHashMap<>();

    public CatalogServices() {
        storage.put(1L,new Book(1L,"Pan Tadeusz","Adam Mickiewicz",1834));
        storage.put(2L,new Book(1L,"Ogniem i mieczem","Henryk Sienkiewicz",1883));
        storage.put(3L,new Book(1L,"Chłopi","Władysław Remont",1904));
    }

    List<Book>findByTitle(String title) {
        return storage.values()
                .stream()
                .filter(book -> book.title.startsWith(title))
                .collect(Collectors.toList());

    }
}
