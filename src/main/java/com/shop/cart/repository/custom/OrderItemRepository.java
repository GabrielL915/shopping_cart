package com.shop.cart.repository.custom;

import com.shop.cart.domain.model.OrderItem;
import com.shop.cart.repository.CRUDRepository;

import java.util.List;

public interface OrderItemRepository extends CRUDRepository<OrderItem, String> {
    List<OrderItem> findByOrderId(String orderId);
}
