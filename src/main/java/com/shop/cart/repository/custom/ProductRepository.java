package com.shop.cart.repository.custom;

import com.shop.cart.domain.model.Product;
import com.shop.cart.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CRUDRepository<Product,String> {
}
