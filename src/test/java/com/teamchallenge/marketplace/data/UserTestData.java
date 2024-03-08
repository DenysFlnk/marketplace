package com.teamchallenge.marketplace.data;

import com.teamchallenge.marketplace.dto.order.OrderHistoryTo;
import com.teamchallenge.marketplace.dto.product.ProductBriefTo;
import com.teamchallenge.marketplace.dto.user.ProfileTo;
import com.teamchallenge.marketplace.dto.user.UserFavoritesTo;
import com.teamchallenge.marketplace.dto.user.UserHistoryTo;
import com.teamchallenge.marketplace.entity.order.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class UserTestData {
    public static ProfileTo getProfileTo() {
        return new ProfileTo(1, null, "John", "john@gmail.com");
    }

    public static UserHistoryTo getUserHistoryTo() {
        List<OrderHistoryTo> orderHistory = List.of(new OrderHistoryTo(1,
                new ProductBriefTo(4, null, "Золотий браслет", 1200), 1, 1200,
                LocalDateTime.of(2024, 1, 9, 19, 10, 25), OrderStatus.COMPLETED));

        return new UserHistoryTo(3, null, "Julia", orderHistory);
    }

    public static UserFavoritesTo getUserFavoritesTo() {
        List<ProductBriefTo> favorites = List.of(new ProductBriefTo(2, null, "Смішна кружка", 280));

        return new UserFavoritesTo(3, null, "Julia", favorites);
    }
}
