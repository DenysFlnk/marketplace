package com.teamchallenge.marketplace.dto.user;

import com.teamchallenge.marketplace.entity.user.UserImage;

import java.util.Objects;

public record UserBriefTo(int id, UserImage avatar, String username) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBriefTo that = (UserBriefTo) o;
        return id == that.id && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
