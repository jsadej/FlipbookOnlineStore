package com.example.flipbook.Order.application;

import com.example.flipbook.Order.application.port.QueryOrderUseCase;
import com.example.flipbook.Order.domain.Order;
import com.example.flipbook.Order.domain.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class QueryOrderServices implements QueryOrderUseCase {
    private  final OrderRepository repository;


    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }
}
