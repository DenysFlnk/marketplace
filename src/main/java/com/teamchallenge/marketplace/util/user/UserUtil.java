package com.teamchallenge.marketplace.util.user;

import com.teamchallenge.marketplace.dto.user.*;
import com.teamchallenge.marketplace.entity.user.User;
import com.teamchallenge.marketplace.entity.user.UserRole;
import com.teamchallenge.marketplace.util.order.OrderUtil;
import com.teamchallenge.marketplace.util.product.ProductUtil;

import java.util.List;
import java.util.Set;

public class UserUtil {
    private UserUtil() {
    }

    public static ProfileTo getProfileTo(User user) {
        return new ProfileTo(user.id(), user.getAvatar(), user.getUsername(), user.getEmail());
    }

    public static UserHistoryTo getUserHistoryTo(User user) {
        return new UserHistoryTo(user.id(), user.getAvatar(), user.getUsername(),
                OrderUtil.getOrderHistoryTos(user.getOrderHistory()));
    }

    public static UserFavoritesTo getUserFavoritesTo(User user) {
        return new UserFavoritesTo(user.id(), user.getAvatar(), user.getUsername(),
                ProductUtil.getProductBriefTos(user.getFavorites()));
    }

    public static User getUser(RegistrationTo form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setRoles(form.getRoles());

        return user;
    }

    public static void setRoleIdsToForm(List<UserRole> allRoles, RegistrationTo form) {
        Set<UserRole> roles = form.getRoles();
        for (UserRole role : roles) {
            allRoles.stream()
                    .filter(item -> item.getName().equals(role.getName()))
                    .findFirst()
                    .ifPresent(r -> role.setId(r.id()));
        }
    }

    public static UserBriefTo getUserBriefTo(User user) {
        return new UserBriefTo(user.id(), user.getAvatar(), user.getUsername());
    }
}
