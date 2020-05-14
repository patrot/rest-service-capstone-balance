package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.ProductBalance;
import com.capstone.restservice.service.ProductBalanceService;
import com.capstone.restservice.service.ProductBalanceServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductBalanceServiceTests {

    @Test
    public void getAllLocationsTest() {

        // Arrange

        List<ProductBalance> expectedProductBalances = new ArrayList<>();
        expectedProductBalances.add(new ProductBalance(1L, 1L, 1L, 10));
        expectedProductBalances.add(new ProductBalance(2L, 1L, 2L, 10));
        expectedProductBalances.add(new ProductBalance(3L, 2L, 1L, 10));
        expectedProductBalances.add(new ProductBalance(4L, 2L, 2L, 10));

        ProductBalanceService productBalanceService = new ProductBalanceServiceImpl();

        // Act

        List<ProductBalance> actualProductBalances = productBalanceService.getAll();

        // Assert

        assertTrue(Arrays.deepEquals(expectedProductBalances.toArray(), actualProductBalances.toArray()));
    }
}
