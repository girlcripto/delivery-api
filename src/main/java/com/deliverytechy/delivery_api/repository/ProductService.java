package com.deliverytechy.delivery_api.service;

import com.deliverytechy.delivery_api.dto.ProductRequest;
import com.deliverytechy.delivery_api.model.Product;
import com.deliverytechy.delivery_api.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllActive() {
        return productRepository.findByActiveTrue();
    }

    @Transactional
    public Product create(ProductRequest request) {
        Product product = new Product(
                request.name(),
                request.description(),
                request.price(),
                true
        );
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}