package com.teamchallenge.marketplace.repository.product;

import com.teamchallenge.marketplace.entity.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> getProductCategoriesByNameIn(List<String> categoryNames);
}
