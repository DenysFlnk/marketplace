package com.teamchallenge.marketplace.util.product;

import com.teamchallenge.marketplace.dto.product.ProductBriefTo;
import com.teamchallenge.marketplace.dto.product.ProductDetailTo;
import com.teamchallenge.marketplace.entity.product.Product;
import com.teamchallenge.marketplace.entity.product.ProductImage;
import com.teamchallenge.marketplace.entity.product.ProductRating;
import com.teamchallenge.marketplace.util.user.UserUtil;

import java.util.List;

public class ProductUtil {
    private ProductUtil() {
    }

    public static List<ProductBriefTo> getProductBriefTos(List<Product> products) {
        return products.stream().map(ProductUtil::getProductBriefTo).toList();
    }

    public static ProductBriefTo getProductBriefTo(Product product) {
        return new ProductBriefTo(product.id(), getFirstOrEmptyImage(product.getImages()), product.getName(),
                product.getPrice(), product.getQuantity() > 0);
    }

    private static ProductImage getFirstOrEmptyImage(List<ProductImage> productImages) {
        return productImages.stream().findFirst().orElse(new ProductImage());
    }

    public static ProductDetailTo getProductDetailTo(Product product) {
        return new ProductDetailTo(product.id(), product.getImages(), UserUtil.getUserBriefTo(product.getCreator()),
                product.getName(), product.getQuantity(), product.getPrice(), product.getDescription(),
                product.getCategories(), getAnnualRating(product.getRatings()));
    }

    private static float getAnnualRating(List<ProductRating> ratings) {
        if (ratings.isEmpty()) {
            return 0f;
        }

        double sum = ratings.stream().mapToDouble(ProductRating::getRating).sum();

        return (float) (sum / ratings.size());
    }
}
