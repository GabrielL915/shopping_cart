package com.shop.cart.domain.adapter.custom;


import com.shop.cart.domain.adapter.Adapter;
import com.shop.cart.domain.dto.OrderDTO;
import com.shop.cart.domain.model.Customer;
import com.shop.cart.domain.model.Order;
import com.shop.cart.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderAdapter implements Adapter<Order, OrderDTO> {

    private final CustomerService service;

    @Override
    public Order fromDTO(OrderDTO orderDTO) {
        Customer customer = service.getReferenceById(orderDTO.customerId());
        return new Order(customer, orderDTO.createdAt(), orderDTO.status());
    }

    @Override
    public OrderDTO fromEntity(Order order) {
        return new OrderDTO(order.getId(), order.getCreatedAt(), order.getCustomer().getId(), order.getStatus());
    }
}
