package com.capstone.restservice.configuration;

import com.capstone.restservice.repository.ProductBalanceDto;
import com.capstone.restservice.repository.ProductBalanceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ProductBalanceRepository productBalanceRepository) {

        return args -> {
            log.info("Existing department items count " + productBalanceRepository.count());

            if (productBalanceRepository.count() < 1) {
                log.info("Preloading " + productBalanceRepository.save(new ProductBalanceDto(1L, 1L, 10)));
                log.info("Preloading " + productBalanceRepository.save(new ProductBalanceDto(1L, 2L, 10)));
                log.info("Preloading " + productBalanceRepository.save(new ProductBalanceDto(2L, 1L, 10)));
                log.info("Preloading " + productBalanceRepository.save(new ProductBalanceDto(2L, 2L, 10)));

            }
        };
    }
}
