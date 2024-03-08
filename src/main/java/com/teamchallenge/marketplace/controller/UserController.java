package com.teamchallenge.marketplace.controller;

import com.teamchallenge.marketplace.dto.user.ProfileTo;
import com.teamchallenge.marketplace.dto.user.UserFavoritesTo;
import com.teamchallenge.marketplace.dto.user.UserHistoryTo;
import com.teamchallenge.marketplace.entity.user.User;
import com.teamchallenge.marketplace.service.UserService;
import com.teamchallenge.marketplace.util.user.UserUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest-api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class UserController {
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ProfileTo getProfile(@PathVariable Integer id) {
        log.info("getProfile: id {}", id);
        User user = userService.get(id);
        return UserUtil.getProfileTo(user);
    }

    @GetMapping(value = "/{id}/history")
    public UserHistoryTo getUserWithHistory(@PathVariable Integer id) {
        log.info("getUserWithHistory: id {}", id);
        User user = userService.getWithHistory(id);
        log.info(user.getOrderHistory().get(0).getProduct().toString());
        return UserUtil.getUserHistoryTo(user);
    }

    @GetMapping(value = "/{id}/favorites")
    public UserFavoritesTo getUserWithFavorites(@PathVariable Integer id) {
        log.info("getUserWithFavorites: id {}", id);
        User user = userService.getWithFavorites(id);
        return UserUtil.getUserFavoritesTo(user);
    }
}
