package com.shop.cart.controller;

import com.shop.cart.domain.dto.CustomerDTO;
import com.shop.cart.domain.model.Customer;
import com.shop.cart.domain.service.CustomerService;
import jakarta.validation.Valid;
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
    public CustomerDTO create(@RequestBody @Valid CustomerDTO customerDTO) {
        return service.create(customerDTO);
    }

    @GetMapping
    public List<CustomerDTO> getAll() {
        return service.findAll();
    }

    @GetMapping(ID_PATH_VARIABLE)
    public CustomerDTO getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping(ID_PATH_VARIABLE)
    @ResponseStatus(value = HttpStatus.OK)
    public CustomerDTO update(@PathVariable String id, @RequestBody @Valid CustomerDTO customerDTO) {
        return service.update(id, customerDTO);
    }

    @DeleteMapping(ID_PATH_VARIABLE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
