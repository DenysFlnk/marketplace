package com.teamchallenge.marketplace.dto.product;

import com.teamchallenge.marketplace.dto.user.UserBriefTo;
import com.teamchallenge.marketplace.entity.product.ProductCategory;
import com.teamchallenge.marketplace.entity.product.ProductImage;

import java.util.List;
import java.util.Objects;

public record ProductDetailTo(int id, List<ProductImage> images, UserBriefTo creator, String name, int quantity,
                              int price, String description, List<ProductCategory> categories, float annualRating) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetailTo that = (ProductDetailTo) o;
        return id == that.id && quantity == that.quantity && price == that.price &&
                Float.compare(that.annualRating, annualRating) == 0 && Objects.equals(creator, that.creator) &&
                Objects.equals(name, that.name) && Objects.equals(description, that.description) &&
                Objects.equals(categories, that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creator, name, quantity, price, description, categories, annualRating);
    }
}
