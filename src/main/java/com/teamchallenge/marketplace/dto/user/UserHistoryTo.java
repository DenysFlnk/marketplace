package com.teamchallenge.marketplace.dto.user;

import com.teamchallenge.marketplace.dto.order.OrderHistoryTo;
import com.teamchallenge.marketplace.entity.user.UserImage;

import java.util.List;
import java.util.Objects;

public record UserHistoryTo(int id, UserImage avatar, String username, List<OrderHistoryTo> orderHistory) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHistoryTo that = (UserHistoryTo) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(orderHistory, that.orderHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, orderHistory);
    }
}
