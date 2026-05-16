package com.deliverytechy.delivery_api.controller;

import com.deliverytechy.delivery_api.model.Order;
import com.deliverytechy.delivery_api.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

// Marks this class as a Spring REST Controller, meaning it handles HTTP requests.
@RestController
// Defines the base URL path for all methods in this controller (e.g., http://localhost:8080/api/orders).
@RequestMapping("/api/orders")
public class OrderController {

    // The repository handles data access (e.g., saving, retrieving) to the 'Order' entity.
    // It's marked as 'final' because it should be initialized once and not changed.
    private final OrderRepository orderRepository;

    // Constructor Injection: Spring automatically provides an instance of OrderRepository
    // when creating the OrderController. This is the preferred way for dependency injection.
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Maps HTTP GET requests to the base path ("/api/orders") to this method.
    // It's used to retrieve a list of all orders.
    @GetMapping
    public List<Order> list() {
        // Calls the repository to fetch all 'Order' entities from the database.
        return orderRepository.findAll();
    }

    // Maps HTTP POST requests to the base path ("/api/orders") to this method.
    // It's used to create a new order.
    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        // @RequestBody: Maps the incoming JSON body of the request into an 'Order' object.

        // 1. Save the new Order to the database. The 'save' method returns the saved entity,
        // which now includes the generated ID.
        Order saved = orderRepository.save(order);

        // 2. Return a professional REST response:
        // - ResponseEntity.created(...): Sets the HTTP status code to 201 Created.
        // - URI.create(...): Adds a 'Location' header to the response, pointing to the new resource's URI.
        // - .body(saved): Sets the body of the response to the newly saved 'Order' object.
        return ResponseEntity.created(URI.create("/api/orders/" + saved.getId())).body(saved);
    }

}