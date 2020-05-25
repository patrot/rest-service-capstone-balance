package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.ProductBalance;
import com.capstone.restservice.repository.ProductBalanceDto;
import com.capstone.restservice.repository.ProductBalanceRepository;
import com.capstone.restservice.service.ProductBalanceService;
import com.capstone.restservice.service.ProductBalanceServiceImpl;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(Parameterized.class)
public class ProductBalanceServiceBalanceAndLocationTests {

    private Long productId;
    private Long locationId;
    private ProductBalance expected;

    @ClassRule
    public static final SpringClassRule scr = new SpringClassRule();

    @Rule
    public final SpringMethodRule smr = new SpringMethodRule();

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
        productBalanceDtos.add(new ProductBalanceDto(1L, 2L, 15));
        productBalanceDtos.add(new ProductBalanceDto(2L, 1L, 11));
        productBalanceDtos.add(new ProductBalanceDto(2L, 2L, 16));

        productBalanceDtos.get(0).setId(1L);
        productBalanceDtos.get(1).setId(2L);
        productBalanceDtos.get(2).setId(3L);
        productBalanceDtos.get(3).setId(4L);

        Mockito.when(productBalanceRepository.findAll())
                .thenReturn(productBalanceDtos);
    }

    public ProductBalanceServiceBalanceAndLocationTests(Long productId, Long locationId, ProductBalance productBalance) {
        this.productId = productId;
        this.locationId = locationId;
        this.expected = productBalance;
    }

    @Parameterized.Parameters
    public static Collection productLocations() {
        return Arrays.asList(new Object[][] {
                {1L, 1L, new ProductBalance(1L, 1L, 1L, 10)},
                {1L, 2L, new ProductBalance(2L, 1L, 2L, 15)},
                {2L, 1L, new ProductBalance(3L, 2L, 1L, 11)},
                {2L, 2L, new ProductBalance(4L, 2L, 2L, 16)},
                {2L, 3L, null}
        });
    };

    @Test
    public void getBalanceByProductAndLocation() {

        // Act

        ProductBalance actualProductBalance = productBalanceService.getBalance(this.productId, this.locationId);

        // Assert

        verify(productBalanceRepository, times(1)).findAll();

        if (this.expected == null) {
            assertNull(actualProductBalance);
        } else {
            assertTrue(this.expected.equals(actualProductBalance));
        }
    }

}
