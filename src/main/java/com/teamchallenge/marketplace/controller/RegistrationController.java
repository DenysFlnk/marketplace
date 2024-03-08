package com.teamchallenge.marketplace.controller;

import com.teamchallenge.marketplace.dto.user.ProfileTo;
import com.teamchallenge.marketplace.dto.user.RegistrationTo;
import com.teamchallenge.marketplace.entity.user.User;
import com.teamchallenge.marketplace.service.UserService;
import com.teamchallenge.marketplace.util.user.UserUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "rest-api/register", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class RegistrationController {
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileTo register(@Valid @RequestBody RegistrationTo form) {
        log.info("register: form {}", form);
        User user = userService.create(form);
        return UserUtil.getProfileTo(user);
    }
}
