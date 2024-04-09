package com.shop.cart.domain.service;

import com.shop.cart.domain.model.Customer;
import com.shop.cart.repository.custom.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public Customer create(Customer newCustomer) {
        return repository.save(newCustomer);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public Customer update(String id, Customer customer) {
        Customer existingCustomer = findById(id);

        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());

        return repository.save(existingCustomer);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
