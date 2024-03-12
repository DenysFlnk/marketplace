package com.teamchallenge.marketplace.service;

import com.teamchallenge.marketplace.entity.product.Product;
import com.teamchallenge.marketplace.repository.product.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
    private ProductRepository productRepository;

    public Product getProduct(int id) {
        return productRepository.getProductWithAllProperties(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
