package com.example.flipbook.catalog.domain;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Book {
    private final Long id;
    public final String title;
    private  final String author;
    private final Integer year;


}
