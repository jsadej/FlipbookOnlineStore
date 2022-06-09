package com.example.flipbook.Order.domain;

import com.example.flipbook.catalog.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
public class Order {

    private Long id;

  @Builder.Default
   private  OrderStatus orderStatus=OrderStatus.NEW;


   private  List<OrderItem> orderItemList;

    private  Recipient recipient;


    private  LocalDateTime createdAt;

    public BigDecimal totalPrice(){
        return orderItemList.stream()
                .map(orderItem -> orderItem.getBook().getPrice().multiply(new BigDecimal(orderItem.getQuantity())))
                .reduce(BigDecimal.ZERO,BigDecimal::add);

    }
}
