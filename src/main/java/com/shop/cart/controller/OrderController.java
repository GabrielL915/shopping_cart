package com.shop.cart.controller;

import com.shop.cart.domain.model.Order;
import com.shop.cart.domain.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private static final String ID_PATH_VARIABLE = "/{id}";

    private final OrderService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Order create(Order newOrder) {
        return service.create(newOrder);
    }

    @GetMapping
    public List<Order> getAll() {
        return service.findAll();
    }
}
