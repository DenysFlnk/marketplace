package com.teamchallenge.marketplace.controller;

import com.teamchallenge.marketplace.AbstractTest;
import com.teamchallenge.marketplace.JsonUtil;
import com.teamchallenge.marketplace.data.ProductTestData;
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
    void getProductsPresentsAndEmbroideryAll() throws Exception {
        int pageNumber = 0, pageSize = 7;
        List<ProductBriefTo> expected = ProductTestData.getPresentsAndEmbroidery(pageNumber, pageSize);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(PRODUCT_URL)
                        .param("categories", "Embroidery", "Present")
                        .param("pageSize", String.valueOf(pageSize))
                        .param("pageNumber", String.valueOf(pageNumber)))
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        List<ProductBriefTo> actual = JsonUtil.readValuesFromJson(getContentAsString(result),ProductBriefTo.class);

        assertIterableEquals(expected, actual);
    }
}