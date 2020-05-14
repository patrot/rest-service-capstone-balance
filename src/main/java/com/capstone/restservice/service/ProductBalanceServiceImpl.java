package com.capstone.restservice.service;

import com.capstone.restservice.domain.ProductBalance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductBalanceServiceImpl implements ProductBalanceService {

    @Override
    public List<ProductBalance> getAll() {

        List<ProductBalance> productBalances = new ArrayList<>();
        productBalances.add(new ProductBalance(1L, 1L, 1L, 10));
        productBalances.add(new ProductBalance(2L, 1L, 2L, 10));
        productBalances.add(new ProductBalance(3L, 2L, 1L, 10));
        productBalances.add(new ProductBalance(4L, 2L, 2L, 10));

        return productBalances;
    }
}
