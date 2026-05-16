package com.deliverytechy.delivery_api.service;

import com.deliverytechy.delivery_api.dto.CustomerRequest;
import com.deliverytechy.delivery_api.model.Customer;
import com.deliverytechy.delivery_api.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAll() { return repository.findAll(); }

    @Transactional
    public Customer create(CustomerRequest request) {
        if (repository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado");
        }
        Customer customer = new Customer(null, request.name(), request.email(), request.phone(), request.address());
        return repository.save(customer);
    }

    public Customer findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}