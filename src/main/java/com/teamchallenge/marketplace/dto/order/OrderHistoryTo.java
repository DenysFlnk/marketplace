package com.teamchallenge.marketplace.dto.order;

import com.teamchallenge.marketplace.dto.product.ProductBriefTo;
import com.teamchallenge.marketplace.entity.order.OrderStatus;

import java.time.LocalDateTime;

public record OrderHistoryTo(int id, ProductBriefTo product, int quantity, int totalPrice, LocalDateTime orderDate,
                             OrderStatus status) {
}
