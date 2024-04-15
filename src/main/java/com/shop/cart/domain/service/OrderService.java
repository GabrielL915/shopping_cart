package com.shop.cart.domain.service;

import com.shop.cart.domain.adapter.Adapter;
import com.shop.cart.domain.dto.OrderDTO;
import com.shop.cart.domain.model.Order;
import com.shop.cart.repository.custom.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final Adapter<Order, OrderDTO> adapter;

    public OrderDTO create(OrderDTO orderDTO) {
        Order newOrder = adapter.fromDTO(orderDTO);
        return adapter.fromEntity(repository.save(newOrder));
    }

    public List<OrderDTO> findAll() {
        return repository.findAll().stream().map(adapter::fromEntity).toList();
    }

    public Order findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("teste"));
    }

}
