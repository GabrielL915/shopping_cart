package com.shop.cart.domain.service;

import com.shop.cart.domain.model.Product;
import com.shop.cart.repository.custom.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product create(Product newProduct) {
        return repository.save(newProduct);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public Product update(String id, Product product) {
        Product existingProduct = findById(id);

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        return repository.save(existingProduct);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
