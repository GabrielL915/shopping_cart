package com.shop.cart.controller;

import com.shop.cart.domain.model.Customer;
import com.shop.cart.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private static final String ID_PATH_VARIABLE = "/{id}";

    private final CustomerService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Customer create(@RequestBody Customer newCustomer) {
        return service.create(newCustomer);
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.findAll();
    }

    @GetMapping(ID_PATH_VARIABLE)
    public Customer getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping(ID_PATH_VARIABLE)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer update(@PathVariable String id, @RequestBody Customer customer) {
        return service.update(id, customer);
    }

    @DeleteMapping(ID_PATH_VARIABLE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
