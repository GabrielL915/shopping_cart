package com.shop.cart.domain.adapter.custom;


import com.shop.cart.domain.adapter.Adapter;
import com.shop.cart.domain.dto.CustomerDTO;
import com.shop.cart.domain.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerAdapter implements Adapter<Customer, CustomerDTO> {
    @Override
    public Customer fromDTO(CustomerDTO customerDTO) {
        return new Customer(customerDTO.name(), customerDTO.email());
    }

    @Override
    public CustomerDTO fromEntity(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail());
    }
}
