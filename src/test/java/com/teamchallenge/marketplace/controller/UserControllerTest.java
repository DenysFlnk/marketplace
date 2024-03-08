package com.teamchallenge.marketplace.controller;

import com.teamchallenge.marketplace.AbstractTest;
import com.teamchallenge.marketplace.JsonUtil;
import com.teamchallenge.marketplace.data.UserTestData;
import com.teamchallenge.marketplace.dto.user.ProfileTo;
import com.teamchallenge.marketplace.dto.user.UserFavoritesTo;
import com.teamchallenge.marketplace.dto.user.UserHistoryTo;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest extends AbstractTest {
    private static final String USER_URL = "/rest-api/users";

    @Test
    void getProfile() throws Exception {
        ProfileTo expected = UserTestData.getProfileTo();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(USER_URL + "/" + expected.id()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        ProfileTo actual = JsonUtil.readValueFromJson(getContentAsString(result), ProfileTo.class);

        assertEquals(expected, actual);
    }

    @Test
    void getUserWithHistory() throws Exception {
        UserHistoryTo expected = UserTestData.getUserHistoryTo();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(USER_URL + "/" + expected.id() +
                        "/history"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        UserHistoryTo actual = JsonUtil.readValueFromJson(getContentAsString(result), UserHistoryTo.class);

        assertEquals(expected, actual);
    }

    @Test
    void getUserWithFavorites() throws Exception {
        UserFavoritesTo expected = UserTestData.getUserFavoritesTo();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(USER_URL + "/" + expected.id() +
                        "/favorites"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        UserFavoritesTo actual = JsonUtil.readValueFromJson(getContentAsString(result), UserFavoritesTo.class);

        assertEquals(expected, actual);
    }
}