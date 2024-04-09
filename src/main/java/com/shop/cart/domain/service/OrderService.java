package com.shop.cart.domain.service;

import com.shop.cart.domain.model.Order;
import com.shop.cart.repository.custom.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public Order create(Order newOrder) {
        return repository.save(newOrder);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }
}
