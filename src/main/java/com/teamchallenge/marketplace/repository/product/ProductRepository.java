package com.teamchallenge.marketplace.repository.product;

import com.teamchallenge.marketplace.entity.product.Product;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    @Transactional
    default Optional<Product> getProductWithAllProperties(int id) {
        Optional<Product> optional = this.findById(id);

        if (optional.isEmpty()) {
            return optional;
        }

        Product product = optional.get();

        Hibernate.initialize(product.getCreator());
        Hibernate.initialize(product.getCategories());
        Hibernate.initialize(product.getRatings());

        optional = Optional.of(product);

        return optional;
    }

    Page<Product> findProductsByNameContaining(String name, Pageable pageable);
}
