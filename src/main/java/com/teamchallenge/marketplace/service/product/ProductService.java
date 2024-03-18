package com.teamchallenge.marketplace.service.product;

import com.teamchallenge.marketplace.entity.product.Product;
import com.teamchallenge.marketplace.entity.product.ProductCategory;
import com.teamchallenge.marketplace.repository.product.ProductCategoryRepository;
import com.teamchallenge.marketplace.repository.product.ProductRepository;
import com.teamchallenge.marketplace.service.product.filter.specification.CategorySpecification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
    private ProductRepository productRepository;

    private ProductCategoryRepository categoryRepository;

    private static final int STARTING_PAGE = 0;

    private static final int PAGE_SIZE = 20; // will change in future

    public Product getProduct(int id) {
        return productRepository.getProductWithAllProperties(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> getProducts(List<String> categories, Map<String, String> params) {
        List<ProductCategory> actualCategories = null;
        if (categories != null) {
            actualCategories = getActualCategories(categories);
        }

        Specification<Product> specification = getSpecification(actualCategories, params);
        Pageable page = getPageable(params);

        return productRepository.findAll(specification, page).getContent();
    }

    private List<ProductCategory> getActualCategories(List<String> categories) {
        return categoryRepository.getProductCategoriesByNameIn(categories);
    }

    private Specification<Product> getSpecification(List<ProductCategory> categories, Map<String, String> params) {
        return Specification.where(new CategorySpecification(categories));
    }

    private Pageable getPageable(Map<String, String> params) {
        int pageNumber = Integer.parseInt(params.getOrDefault("pageNumber", String.valueOf(STARTING_PAGE)));
        int pageSize = Integer.parseInt(params.getOrDefault("pageSize", String.valueOf(PAGE_SIZE)));

        return PageRequest.of(pageNumber, pageSize);
    }
}
