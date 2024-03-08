package com.teamchallenge.marketplace.controller;

import com.teamchallenge.marketplace.AbstractTest;
import com.teamchallenge.marketplace.JsonUtil;
import com.teamchallenge.marketplace.dto.user.ProfileTo;
import com.teamchallenge.marketplace.dto.user.RegistrationTo;
import com.teamchallenge.marketplace.entity.user.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RegistrationControllerTest extends AbstractTest {
    private static final String REGISTRATION_URL = "/rest-api/register";

    @Test
    void register() throws Exception {
        RegistrationTo registration = new RegistrationTo("new User", "newUser@gmail.com", "passUser66",
                Set.of(new UserRole("USER")));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(REGISTRATION_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.writeValueToJson(registration)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        ProfileTo actual = JsonUtil.readValueFromJson(getContentAsString(result), ProfileTo.class);
        ProfileTo expected = new ProfileTo(actual.id(), null, registration.getUsername(), registration.getEmail());

        assertEquals(expected, actual);
    }
}