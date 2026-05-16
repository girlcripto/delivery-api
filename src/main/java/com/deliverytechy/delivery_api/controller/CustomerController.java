package com.deliverytechy.delivery_api.controller;

import com.deliverytechy.delivery_api.dto.CustomerRequest;
import com.deliverytechy.delivery_api.model.Customer;
import com.deliverytechy.delivery_api.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) { this.service = service; }

    @GetMapping
    public List<Customer> getAll() { return service.findAll(); }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }
}