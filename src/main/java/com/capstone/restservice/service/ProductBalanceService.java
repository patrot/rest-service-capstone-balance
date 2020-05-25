package com.capstone.restservice.service;

import com.capstone.restservice.domain.ProductBalance;

import java.util.List;

public interface ProductBalanceService {
    List<ProductBalance> getAll();

    ProductBalance getBalance(Long productId, Long locationId);
}
