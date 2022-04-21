package com.example.flipbook.catalog.domain;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Book {
    private Long id;
    public  String title;
    private  String author;
    private  Integer year;

    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
