package com.example.flipbook.Order.infrastucture;

import com.example.flipbook.Order.domain.Order;
import com.example.flipbook.Order.domain.OrderRepository;
import com.example.flipbook.catalog.domain.Book;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class MemoryOrderRepository implements OrderRepository {

    private final Map<Long, Order> storage = new ConcurrentHashMap<>();
    private final AtomicLong Next_ID = new AtomicLong(1);

    @Override
    public Order save(Order order) {
        if(order.getId() != null) {
            storage.put(order.getId(),order);

        }else{
            long next_id=nextId();
            order.setId(next_id);
            order.setCreatedAt(LocalDateTime.now());
            storage.put(next_id,order);
        }
        return  order;
    }

    @Override
    public List<Order> findAll() {

        return new ArrayList<>(storage.values());
    }

    private long nextId() {
        return Next_ID.getAndIncrement();

    }
}

