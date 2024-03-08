package com.teamchallenge.marketplace.dto.user;

import com.teamchallenge.marketplace.dto.product.ProductBriefTo;
import com.teamchallenge.marketplace.entity.user.UserImage;

import java.util.List;
import java.util.Objects;

public record UserFavoritesTo(int id, UserImage avatar, String username, List<ProductBriefTo> favorites) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFavoritesTo that = (UserFavoritesTo) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(favorites, that.favorites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, favorites);
    }
}
