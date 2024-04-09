package com.shop.cart.repository.custom;

import com.shop.cart.domain.model.Order;
import com.shop.cart.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CRUDRepository<Order, String> {
}
