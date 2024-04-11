package com.shop.cart.controller;

import com.shop.cart.domain.model.Order;
import com.shop.cart.domain.model.OrderItem;
import com.shop.cart.domain.service.OrderItemService;
import com.shop.cart.domain.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private static final String ID_PATH_VARIABLE = "/{orderId}";

    private final OrderService service;
    private final OrderItemService orderItemService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Order create(@RequestBody Order newOrder) {
        return service.create(newOrder);
    }

    @GetMapping
    public List<Order> getAll() {
        return service.findAll();
    }


    @PostMapping(path = "/orderItem")
    @ResponseStatus(value = HttpStatus.CREATED)
    public OrderItem addOrderToOrderItem(@RequestBody OrderItem newOrderItem) {
        return orderItemService.addOrderItemToOrder(newOrderItem.getOrderId(), newOrderItem);
    }

    @GetMapping(ID_PATH_VARIABLE)
    public List<OrderItem> getAllOrderItemByOrderId(@PathVariable String orderId) {
        return orderItemService.findByOrderId(orderId);
    }
}
