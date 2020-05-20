package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.ProductBalance;
import com.capstone.restservice.repository.ProductBalanceDto;
import com.capstone.restservice.repository.ProductBalanceRepository;
import com.capstone.restservice.service.ProductBalanceService;
import com.capstone.restservice.service.ProductBalanceServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class ProductBalanceServiceTests {

    @TestConfiguration
    static class DepartmentServiceImplTestContextConfiguration {

        @Bean
        public ProductBalanceService departmentService() {
            return new ProductBalanceServiceImpl();
        }
    }

    @Autowired
    ProductBalanceService productBalanceService;

    @MockBean
    private ProductBalanceRepository productBalanceRepository;

    @Before
    public void setUp() {
        List<ProductBalanceDto> productBalanceDtos = new ArrayList<>();
        productBalanceDtos.add(new ProductBalanceDto(1L, 1L, 10));
        productBalanceDtos.add(new ProductBalanceDto(1L, 2L, 10));
        productBalanceDtos.add(new ProductBalanceDto(2L, 1L, 10));
        productBalanceDtos.add(new ProductBalanceDto(2L, 2L, 10));

        productBalanceDtos.get(0).setId(1L);
        productBalanceDtos.get(1).setId(2L);
        productBalanceDtos.get(2).setId(3L);
        productBalanceDtos.get(3).setId(4L);

        Mockito.when(productBalanceRepository.findAll())
                .thenReturn(productBalanceDtos);
    }

    @Test
    public void getAllLocationsTest() {

        // Arrange

        List<ProductBalance> expectedProductBalances = new ArrayList<>();
        expectedProductBalances.add(new ProductBalance(1L, 1L, 1L, 10));
        expectedProductBalances.add(new ProductBalance(2L, 1L, 2L, 10));
        expectedProductBalances.add(new ProductBalance(3L, 2L, 1L, 10));
        expectedProductBalances.add(new ProductBalance(4L, 2L, 2L, 10));

        // Act

        List<ProductBalance> actualProductBalances = productBalanceService.getAll();

        // Assert

        verify(productBalanceRepository, times(1)).findAll();

        assertTrue(Arrays.deepEquals(expectedProductBalances.toArray(), actualProductBalances.toArray()));
    }
}
