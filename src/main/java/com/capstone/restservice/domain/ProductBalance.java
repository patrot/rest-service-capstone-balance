package com.capstone.restservice.domain;

import lombok.Data;

@Data
public class ProductBalance {
    private Long id;
    private Long productId;
    private Long locationId;
    private int quantity;

    public ProductBalance() {}

    public ProductBalance(Long id, Long productId, Long locationId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.locationId = locationId;
        this.quantity = quantity;
    }
}
