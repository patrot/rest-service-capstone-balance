package com.capstone.restservice.service;

import com.capstone.restservice.domain.ProductBalance;
import com.capstone.restservice.repository.ProductBalanceDto;
import com.capstone.restservice.repository.ProductBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductBalanceServiceImpl implements ProductBalanceService {

    @Autowired
    private ProductBalanceRepository productBalanceRepository;

    @Override
    public List<ProductBalance> getAll() {
        List<ProductBalanceDto> productBalanceDtos = productBalanceRepository.findAll();

        List<ProductBalance> productBalances = new ArrayList<>();

        for (ProductBalanceDto productBalanceDto:productBalanceDtos) {
            productBalances.add(new ProductBalance(
                    productBalanceDto.getId(), productBalanceDto.getProductId(), productBalanceDto.getLocationId(), productBalanceDto.getQuantity()));
        }

        return productBalances;
    }
}
