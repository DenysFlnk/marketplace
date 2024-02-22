package com.teamchallenge.marketplace;

import com.teamchallenge.marketplace.entity.user.User;
import com.teamchallenge.marketplace.entity.user.UserRole;
import com.teamchallenge.marketplace.entity.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class MarketplaceApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void getUserJulia() {
        User julia = userService.get(3);
        log.info("User Julia: " + julia);
        log.info(julia.getFavorites().toString());
        UserRole role = new UserRole("MOck RoLe");
        role = userService.saveRole(role);
        julia.getRoles().add(role);
        julia = userService.save(julia);
        log.info("User Julia: " + julia);
        log.info(julia.getFavorites().toString());
    }

}
