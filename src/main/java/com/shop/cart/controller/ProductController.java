package com.shop.cart.controller;

import com.shop.cart.domain.dto.ProductDTO;
import com.shop.cart.domain.model.Product;
import com.shop.cart.domain.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private static final String ID_PATH_VARIABLE = "/{id}";

    private final ProductService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ProductDTO create(@RequestBody @Valid ProductDTO product) {
        return service.create(product);
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return service.findAll();
    }

    @GetMapping(ID_PATH_VARIABLE)
    public ProductDTO getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping(ID_PATH_VARIABLE)
    @ResponseStatus(value = HttpStatus.OK)
    public ProductDTO update(@PathVariable String id, @RequestBody @Valid ProductDTO product) {
        return service.update(id, product);
    }

    @DeleteMapping(ID_PATH_VARIABLE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
