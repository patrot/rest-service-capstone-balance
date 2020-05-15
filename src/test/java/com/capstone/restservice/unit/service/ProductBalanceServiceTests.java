package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.ProductBalance;
import com.capstone.restservice.repository.ProductBalanceDto;
import com.capstone.restservice.service.ProductBalanceServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductBalanceServiceTests {

    @Test
    public void getAllLocationsTest() {

        // Arrange

        List<ProductBalanceDto> productBalanceDtos = new ArrayList<>();
        productBalanceDtos.add(new ProductBalanceDto(1L, 1L, 10));
        productBalanceDtos.add(new ProductBalanceDto(1L, 2L, 10));
        productBalanceDtos.add(new ProductBalanceDto(2L, 1L, 10));
        productBalanceDtos.add(new ProductBalanceDto(2L, 2L, 10));

        MockProductBalanceRepository mockProductBalanceRepository = new MockProductBalanceRepository(productBalanceDtos);
        ProductBalanceServiceImpl productBalanceService = new ProductBalanceServiceImpl();
        productBalanceService.setRepository(mockProductBalanceRepository);

        List<ProductBalance> expectedProductBalances = new ArrayList<>();
        for (ProductBalanceDto productBalanceDto:productBalanceDtos) {
            expectedProductBalances.add(new ProductBalance(
                    productBalanceDto.getId(),
                    productBalanceDto.getProductId(),
                    productBalanceDto.getLocationId(),
                    productBalanceDto.getQuantity()));
        }


        // Act

        List<ProductBalance> actualProductBalances = productBalanceService.getAll();

        // Assert

        assertTrue(Arrays.deepEquals(expectedProductBalances.toArray(), actualProductBalances.toArray()));

        assertEquals(1, mockProductBalanceRepository.getFindAllInvocationCount());
    }
}
