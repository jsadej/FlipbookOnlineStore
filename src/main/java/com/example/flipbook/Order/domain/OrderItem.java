package com.example.flipbook.Order.domain;

import com.example.flipbook.catalog.domain.Book;
import lombok.Value;

@Value
public class OrderItem {
    Book book;
    int quantity;
}
