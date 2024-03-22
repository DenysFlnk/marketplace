package com.teamchallenge.marketplace.controller;

import com.teamchallenge.marketplace.dto.PageTo;
import com.teamchallenge.marketplace.dto.product.ProductBriefTo;
import com.teamchallenge.marketplace.dto.product.ProductDetailTo;
import com.teamchallenge.marketplace.entity.product.Product;
import com.teamchallenge.marketplace.service.product.ProductService;
import com.teamchallenge.marketplace.util.product.ProductUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping
    public PageTo<ProductBriefTo> getProducts(@RequestParam(required = false) List<String> categories,
                                              @RequestParam(required = false) Map<String, String> params) {
        log.info("getProducts: categories {}, parameters {}", categories, params);
        Page<Product> page = productService.getProducts(categories, params);
        return ProductUtil.getProductBriefPageTo(page);
    }

    @GetMapping(value = "/search")
    public PageTo<ProductBriefTo> searchProducts(@RequestParam(required = false) Map<String, String> params) {
        log.info("searchProducts: params {}", params);
        Page<Product> page = productService.searchProducts(params);
        return ProductUtil.getProductBriefPageTo(page);
    }
}
