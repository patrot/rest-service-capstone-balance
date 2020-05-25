package com.capstone.restservice.controller;

import com.capstone.restservice.domain.ProductBalance;
import com.capstone.restservice.service.ProductBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @Autowired
    private ProductBalanceService productBalanceService;

    @GetMapping("/balance")
    public ProductBalance getBalance(@RequestParam Long productId, @RequestParam Long locationId) {

        ProductBalance productBalance = productBalanceService.getBalance(productId, locationId);

        if (productBalance == null) {
            return new ProductBalance(0L, productId, locationId, 0);
        }

        return productBalance;
    }
}
