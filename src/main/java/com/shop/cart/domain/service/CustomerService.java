package com.shop.cart.domain.service;

import com.shop.cart.domain.adapter.Adapter;
import com.shop.cart.domain.dto.CustomerDTO;
import com.shop.cart.domain.model.Customer;
import com.shop.cart.repository.custom.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    private final Adapter<Customer, CustomerDTO> adapter;

    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer newCustomer = adapter.fromDTO(customerDTO);
        return getDTOFromEntity(repository.save(newCustomer));
    }

    public List<CustomerDTO> findAll() {
        return repository.findAll().stream().map(this::getDTOFromEntity).toList();
    }

    public CustomerDTO findById(String id) {
        return getDTOFromEntity(getById(id));
    }

    public CustomerDTO update(String id, CustomerDTO customerDTO) {
        Customer existingCustomer = getById(id);

        existingCustomer.setName(customerDTO.name());
        existingCustomer.setEmail(customerDTO.email());

        return getDTOFromEntity(repository.save(existingCustomer));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    private CustomerDTO getDTOFromEntity(Customer customer) {
        return adapter.fromEntity(customer);
    }

    private Customer getById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public Customer getReferenceById(String id) {
        return repository.getReferenceById(id);
    }
}
