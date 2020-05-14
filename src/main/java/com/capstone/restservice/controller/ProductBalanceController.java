package com.capstone.restservice.controller;

import com.capstone.restservice.domain.ProductBalance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductBalanceController {

    @GetMapping("/productbalances")
    public List<ProductBalance> allBalances() {

        List<ProductBalance> productBalances = new ArrayList<>();
        productBalances.add(new ProductBalance(1L, 1L, 1L, 10));
        productBalances.add(new ProductBalance(2L, 1L, 2L, 10));
        productBalances.add(new ProductBalance(3L, 2L, 1L, 10));
        productBalances.add(new ProductBalance(4L, 2L, 2L, 10));

        return productBalances;
    }
}
