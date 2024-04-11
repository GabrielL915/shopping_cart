package com.shop.cart.domain.service;


import com.shop.cart.domain.model.Order;
import com.shop.cart.domain.model.OrderItem;
import com.shop.cart.repository.custom.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository repository;

    private final OrderService orderService;

    public OrderItem addOrderItemToOrder(String orderId, OrderItem orderItem) {
        Order order = orderService.findById(orderId);
        orderItem.setOrderId(order.getId());
        return repository.save(orderItem);
    }

    public List<OrderItem> findByOrderId(String orderId) {
        return repository.findByOrderId(orderId);
    }
}
