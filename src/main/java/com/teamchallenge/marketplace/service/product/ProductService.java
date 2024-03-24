package com.teamchallenge.marketplace.service.product;

import com.teamchallenge.marketplace.entity.product.Product;
import com.teamchallenge.marketplace.entity.product.ProductCategory;
import com.teamchallenge.marketplace.repository.product.ProductCategoryRepository;
import com.teamchallenge.marketplace.repository.product.ProductRepository;
import com.teamchallenge.marketplace.service.PageProps;
import com.teamchallenge.marketplace.service.product.filter.specification.CategorySpecification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Product getProduct(int id) {
        return productRepository.getProductWithAllProperties(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Page<Product> getProducts(List<String> categories, Map<String, String> params) {
        List<ProductCategory> actualCategories = null;
        if (categories != null) {
            actualCategories = getActualCategories(categories);
        }

        Specification<Product> specification = getSpecification(actualCategories, params);
        Pageable page = getPageable(params);
        return productRepository.findAll(specification, page);
    }

    public Page<Product> searchProducts(Map<String, String> params) {
        Pageable page = getPageable(params);
        String name = params.getOrDefault("name", "");

        return productRepository.findProductsByNameContaining(name, page);
    }

    private List<ProductCategory> getActualCategories(List<String> categories) {
        List<String> categoriesCaseInsensitive = categories.stream()
                .map(String::toLowerCase)
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .toList();
        return categoryRepository.getProductCategoriesByNameIn(categoriesCaseInsensitive);
    }

    private Specification<Product> getSpecification(List<ProductCategory> categories, Map<String, String> params) {
        return Specification.where(new CategorySpecification(categories));
    }

    private Pageable getPageable(Map<String, String> params) {
        int pageNumber = Integer.parseInt(params.getOrDefault("pageNumber", String.valueOf(PageProps.STARTING_PAGE)));
        int pageSize = Integer.parseInt(params.getOrDefault("pageSize", String.valueOf(PageProps.PAGE_SIZE)));

        String sortProps = params.get("sort");
        Sort sort;
        if (sortProps != null) {
            String direction = params.getOrDefault("direction", PageProps.SORT_DIRECTION);
            sort = Sort.by(Sort.Direction.fromString(direction), sortProps);
        } else {
            sort = PageProps.SORT_UNSORTED;
        }

        return PageRequest.of(pageNumber, pageSize, sort);
    }
}
