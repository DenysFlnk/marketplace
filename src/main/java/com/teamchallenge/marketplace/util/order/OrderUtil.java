package com.teamchallenge.marketplace.util.order;

import com.teamchallenge.marketplace.dto.order.OrderHistoryTo;
import com.teamchallenge.marketplace.entity.order.Order;
import com.teamchallenge.marketplace.util.product.ProductUtil;

import java.util.List;

public class OrderUtil {
    private OrderUtil() {
    }

    public static List<OrderHistoryTo> getOrderHistoryTos(List<Order> orders) {
        return orders.stream().map(OrderUtil::getOrderHistoryTo).toList();
    }

    public static OrderHistoryTo getOrderHistoryTo(Order order) {
        return new OrderHistoryTo(order.id(), ProductUtil.getProductBriefTo(order.getProduct()), order.getQuantity(),
                order.getTotalPrice(), order.getOrderDate(), order.getStatus());
    }
}
