package com.example.flipbook.Order.application;

import com.example.flipbook.Order.application.port.PlaceOrderUseCase;
import com.example.flipbook.Order.domain.Order;
import com.example.flipbook.Order.domain.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlaceOrderServices implements PlaceOrderUseCase {
    private  final OrderRepository repository;

    @Override
    public PlaceOrderResponse placeOrder(PlaceOrderCommand command) {
        Order order= Order
                .builder()
                .recipient(command.getRecipient())
                .orderItemList(command.getItems())
                .build();
        Order save = repository.save(order);

        return PlaceOrderResponse.success(save.getId());



    }
}
