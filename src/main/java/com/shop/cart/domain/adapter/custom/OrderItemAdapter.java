package com.shop.cart.domain.adapter.custom;

import com.shop.cart.domain.adapter.Adapter;
import com.shop.cart.domain.dto.OrderItemDTO;
import com.shop.cart.domain.model.Order;
import com.shop.cart.domain.model.OrderItem;
import com.shop.cart.domain.model.Product;
import com.shop.cart.repository.custom.OrderRepository;
import com.shop.cart.repository.custom.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemAdapter implements Adapter<OrderItem, OrderItemDTO> {


    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public OrderItem fromDTO(OrderItemDTO orderItemDTO) {
        Product product = productRepository.getReferenceById(orderItemDTO.productId());
        Order order = orderRepository.getReferenceById(orderItemDTO.orderId());
        return new OrderItem(product, orderItemDTO.quantity(), order);
    }

    @Override
    public OrderItemDTO fromEntity(OrderItem orderItem) {
        return new OrderItemDTO(orderItem.getId(), orderItem.getProduct().getId(), orderItem.getQuantity(), orderItem.getOrder().getId());
    }
}
