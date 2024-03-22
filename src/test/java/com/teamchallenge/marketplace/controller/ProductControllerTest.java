package com.teamchallenge.marketplace.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.teamchallenge.marketplace.AbstractTest;
import com.teamchallenge.marketplace.JsonUtil;
import com.teamchallenge.marketplace.data.ProductTestData;
import com.teamchallenge.marketplace.dto.PageTo;
import com.teamchallenge.marketplace.dto.product.ProductBriefTo;
import com.teamchallenge.marketplace.dto.product.ProductDetailTo;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductControllerTest extends AbstractTest {
    private static final String PRODUCT_URL = "/rest-api/products";

    @Test
    void getProduct() throws Exception {
        ProductDetailTo expected = ProductTestData.getProductDetailTo();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(PRODUCT_URL + "/" + expected.id()))
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ProductDetailTo actual = JsonUtil.readValueFromJson(getContentAsString(result), ProductDetailTo.class);

        assertEquals(expected, actual);
    }

    @Test
    void getProductsPresentsAndEmbroidery() throws Exception {
        int pageNumber = 0, pageSize = 2;
        int expectedTotalProducts = ProductTestData.getPresentsAndEmbroidery(0, Integer.MAX_VALUE).size();
        List<ProductBriefTo> expectedContent = ProductTestData.getPresentsAndEmbroidery(pageNumber, pageSize);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(PRODUCT_URL)
                        .param("categories", "Embroidery", "Present")
                        .param("pageSize", String.valueOf(pageSize))
                        .param("pageNumber", String.valueOf(pageNumber)))
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        PageTo<ProductBriefTo> actual = JsonUtil.readValueFromJson(getContentAsString(result), new TypeReference<>(){});
        int actualTotalProducts = actual.totalEntries();
        List<ProductBriefTo> actualContent = actual.content();

        assertEquals(expectedTotalProducts, actualTotalProducts);
        assertIterableEquals(expectedContent, actualContent);
    }

    @Test
    void searchProducts() throws Exception {
        ProductBriefTo expected = ProductTestData.getFunnyHat();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(PRODUCT_URL + "/search")
                        .param("name", "Смішна шапка"))
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        PageTo<ProductBriefTo> actualPage = JsonUtil.readValueFromJson(getContentAsString(result), new TypeReference<>(){});
        List<ProductBriefTo> actualContent = actualPage.content();
        ProductBriefTo actual = actualContent.get(0);

        assertEquals(expected, actual);
    }
}