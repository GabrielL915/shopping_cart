package com.shop.cart.domain.service;


import com.shop.cart.domain.adapter.Adapter;
import com.shop.cart.domain.dto.OrderItemDTO;
import com.shop.cart.domain.model.Order;
import com.shop.cart.domain.model.OrderItem;
import com.shop.cart.repository.custom.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository repository;

    private final Adapter<OrderItem, OrderItemDTO> adapter;

    private final OrderService orderService;

    public OrderItemDTO addOrderItemToOrder(OrderItemDTO orderItemDTO) {
        Order order = getById(orderItemDTO);

        OrderItem newOrderItem = adapter.fromDTO(orderItemDTO);
        newOrderItem.setOrder(order);

        return adapter.fromEntity(repository.save(newOrderItem));
    }

    public List<OrderItemDTO> findByOrderId(String orderId) {
        return repository.findByOrderId(orderId).stream().map(adapter::fromEntity).toList();
    }

    private Order getById(OrderItemDTO orderItemDTO) {
        return orderService.findById(orderItemDTO.orderId());
    }

}
