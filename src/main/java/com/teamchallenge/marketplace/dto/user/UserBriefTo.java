package com.teamchallenge.marketplace.dto.user;

import com.teamchallenge.marketplace.entity.user.UserImage;

public record UserBriefTo(int id, UserImage avatar, String username) {
}
