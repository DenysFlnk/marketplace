package com.teamchallenge.marketplace.service.product.filter.specification;

import com.teamchallenge.marketplace.entity.product.Product;
import com.teamchallenge.marketplace.entity.product.ProductCategory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CategorySpecification implements Specification<Product> {
    private final List<ProductCategory> categories;

    public CategorySpecification(List<ProductCategory> categories) {
        this.categories = categories;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (categories == null) {
            return criteriaBuilder.conjunction(); //return always true predicate
        }

        Predicate[] predicates = categories.stream()
                .map(category -> criteriaBuilder.isMember(category, root.get("categories")))
                .toArray(Predicate[]::new);

        return criteriaBuilder.or(predicates);
    }
}
