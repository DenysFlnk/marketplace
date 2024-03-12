package com.teamchallenge.marketplace.dto.product;

import com.teamchallenge.marketplace.dto.user.UserBriefTo;
import com.teamchallenge.marketplace.entity.product.ProductCategory;
import com.teamchallenge.marketplace.entity.product.ProductImage;

import java.util.List;

public record ProductDetailTo(int id, List<ProductImage> images, UserBriefTo creator, String name, int quantity,
                              int price, String description, List<ProductCategory> categories, float annualRating) {
}
