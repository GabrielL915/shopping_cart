package com.shop.cart.domain.adapter.custom;

import com.shop.cart.domain.adapter.Adapter;
import com.shop.cart.domain.dto.ProductDTO;
import com.shop.cart.domain.model.Product;

public class ProductAdapter implements Adapter<Product, ProductDTO> {
    @Override
    public Product fromDTO(ProductDTO productDTO) {
        return new Product(productDTO.name(), productDTO.price());
    }

    @Override
    public ProductDTO fromEntity(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getPrice());
    }
}
