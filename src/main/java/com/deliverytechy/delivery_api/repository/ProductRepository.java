package com.deliverytechy.delivery_api.repository;

import com.deliverytechy.delivery_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByActiveTrue();
}