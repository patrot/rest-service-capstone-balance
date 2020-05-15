package com.capstone.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBalanceRepository  extends JpaRepository<ProductBalanceDto, Long> {
}
