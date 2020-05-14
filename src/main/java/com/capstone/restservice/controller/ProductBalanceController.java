package com.capstone.restservice.controller;

import com.capstone.restservice.domain.ProductBalance;
import com.capstone.restservice.service.ProductBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductBalanceController {

    @Autowired
    private ProductBalanceService productBalanceService;

    @GetMapping("/productbalances")
    public List<ProductBalance> allBalances() {

        return productBalanceService.getAll();
    }
}
