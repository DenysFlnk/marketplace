package com.teamchallenge.marketplace.util.product;

import com.teamchallenge.marketplace.dto.product.ProductBriefTo;
import com.teamchallenge.marketplace.entity.product.Product;
import com.teamchallenge.marketplace.entity.product.ProductImage;

import java.util.List;

public class ProductUtil {
    private ProductUtil() {
    }

    public static List<ProductBriefTo> getProductBriefTos(List<Product> products) {
        return products.stream().map(ProductUtil::getProductBriefTo).toList();
    }

    public static ProductBriefTo getProductBriefTo(Product product) {
        return new ProductBriefTo(product.id(), getFirstOrEmptyImage(product.getImages()), product.getName(),
                product.getPrice());
    }

    private static ProductImage getFirstOrEmptyImage(List<ProductImage> productImages) {
        return productImages.stream().findFirst().orElse(new ProductImage());
    }
}
