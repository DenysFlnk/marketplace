package com.teamchallenge.marketplace.dto.product;

import com.teamchallenge.marketplace.entity.product.ProductImage;

import java.util.Objects;

public record ProductBriefTo(int id, ProductImage image, String name, int price, boolean isAvailable) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBriefTo that = (ProductBriefTo) o;
        return id == that.id && price == that.price && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
