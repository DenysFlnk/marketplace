package com.teamchallenge.marketplace.controller;

import com.teamchallenge.marketplace.dto.product.ProductDetailTo;
import com.teamchallenge.marketplace.service.ProductService;
import com.teamchallenge.marketplace.util.product.ProductUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest-api/products", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class ProductController {
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ProductDetailTo getProduct(@PathVariable Integer id) {
        log.info("getProduct: id {}", id);
        return ProductUtil.getProductDetailTo(productService.getProduct(id));
    }
}
