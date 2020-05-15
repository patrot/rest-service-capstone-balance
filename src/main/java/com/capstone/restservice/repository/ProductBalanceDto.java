package com.capstone.restservice.repository;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "productbalance")
public class ProductBalanceDto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "productid")
    private Long productId;

    @Column(name = "locationid")
    private Long locationId;

    @Column(name = "quantity")
    private int quantity;

    public ProductBalanceDto() {}

    public ProductBalanceDto(Long productId, Long locationId, int quantity) {
        this.productId = productId;
        this.locationId = locationId;
        this.quantity = quantity;
    }
}
