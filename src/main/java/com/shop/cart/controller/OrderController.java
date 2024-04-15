package com.shop.cart.controller;

import com.shop.cart.domain.dto.OrderDTO;
import com.shop.cart.domain.dto.OrderItemDTO;
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
    public OrderDTO create(@RequestBody OrderDTO orderDTO) {
        return service.create(orderDTO);
    }

    @GetMapping
    public List<OrderDTO> getAll() {
        return service.findAll();
    }


    @PostMapping(path = "/orderItem")
    @ResponseStatus(value = HttpStatus.CREATED)
    public OrderItemDTO addOrderToOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        return orderItemService.addOrderItemToOrder(orderItemDTO);
    }

    @GetMapping(ID_PATH_VARIABLE)
    public List<OrderItemDTO> getAllOrderItemByOrderId(@PathVariable String orderId) {
        return orderItemService.findByOrderId(orderId);
    }
}
