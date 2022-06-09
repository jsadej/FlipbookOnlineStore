package com.example.flipbook.Order.application.port;

import com.example.flipbook.Order.domain.Order;

import java.util.List;

public interface QueryOrderUseCase {
    List<Order> findAll();
}
