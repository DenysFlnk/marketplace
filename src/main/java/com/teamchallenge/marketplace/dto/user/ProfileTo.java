package com.teamchallenge.marketplace.dto.user;

import com.teamchallenge.marketplace.entity.user.UserImage;

import java.util.Objects;

public record ProfileTo(int id, UserImage avatar, String username, String email) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileTo profileTo = (ProfileTo) o;
        return id == profileTo.id && Objects.equals(username, profileTo.username) && Objects.equals(email, profileTo.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email);
    }
}
