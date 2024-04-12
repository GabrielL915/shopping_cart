package com.shop.cart.domain.service;

import com.shop.cart.domain.adapter.Adapter;
import com.shop.cart.domain.dto.CustomerDTO;
import com.shop.cart.domain.dto.ProductDTO;
import com.shop.cart.domain.model.Customer;
import com.shop.cart.domain.model.Product;
import com.shop.cart.repository.custom.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final Adapter<Product, ProductDTO> adapter;

    public ProductDTO create(ProductDTO productDTO) {
        Product newProduct = adapter.fromDTO(productDTO);
        return getDTOFromEntity(repository.save(newProduct));
    }

    public List<ProductDTO> findAll() {
        return repository.findAll().stream().map(this::getDTOFromEntity).toList();
    }

    public ProductDTO findById(String id) {
        Product existingProduct = getById(id);
        return getDTOFromEntity(existingProduct);
    }

    public ProductDTO update(String id, ProductDTO productDTO) {
        Product existingProduct = getById(id);

        existingProduct.setName(productDTO.name());
        existingProduct.setPrice(productDTO.price());

        return getDTOFromEntity(repository.save(existingProduct));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }


    private ProductDTO getDTOFromEntity(Product product) {
        return adapter.fromEntity(product);
    }

    private Product getById(String id) {
        return repository.findById(id).orElseThrow();
    }
}
