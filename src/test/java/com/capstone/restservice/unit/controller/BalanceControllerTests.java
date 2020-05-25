package com.capstone.restservice.unit.controller;

import com.capstone.restservice.controller.BalanceController;
import com.capstone.restservice.domain.ProductBalance;
import com.capstone.restservice.service.ProductBalanceService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(BalanceController.class)
public class BalanceControllerTests {
    Long productId;
    Long locationId;
    Integer expectedBalance;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductBalanceService productBalanceService;

    BalanceControllerTests() {
        this.productId = 1L;
        this.locationId = 1L;
        this.expectedBalance = 10;
    }

    @Test
    public void GetBalanceByProductAndLocation() throws Exception {

        // Arrange

        ProductBalance productBalance = new ProductBalance(1L, this.productId, this.locationId, this.expectedBalance);

        when(productBalanceService.getBalance(this.productId, this.locationId)).thenReturn(productBalance);

        // Act

        MvcResult result = this.mockMvc.perform(get("/balance?productId=" + this.productId + "&locationId=" + this.locationId )).
                andDo(print()).andReturn();

        // Assert

        verify(productBalanceService, times(1)).getBalance(this.productId, this.locationId);

        String response = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        ProductBalance actualProductBalance = objectMapper.readValue(response, new TypeReference<>() {});
        assertTrue(productBalance.equals(actualProductBalance));
    }

    @Test
    public void GetNullBalanceByProductAndLocation() throws Exception {

        // Arrange

        ProductBalance productBalance = new ProductBalance(0L, this.productId, this.locationId, 0);

        when(productBalanceService.getBalance(this.productId, this.locationId)).thenReturn(null);

        // Act

        MvcResult result = this.mockMvc.perform(get("/balance?productId=" + this.productId + "&locationId=" + this.locationId )).
                andDo(print()).andReturn();

        // Assert

        verify(productBalanceService, times(1)).getBalance(this.productId, this.locationId);

        String response = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        ProductBalance actualProductBalance = objectMapper.readValue(response, new TypeReference<>() {});
        assertTrue(productBalance.equals(actualProductBalance));
    }
}
