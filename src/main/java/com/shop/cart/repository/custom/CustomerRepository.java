package com.shop.cart.repository.custom;

import com.shop.cart.domain.model.Customer;
import com.shop.cart.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CRUDRepository<Customer, String> {
}
