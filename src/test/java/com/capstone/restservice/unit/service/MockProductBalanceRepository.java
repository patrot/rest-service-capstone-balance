package com.capstone.restservice.unit.service;

import com.capstone.restservice.repository.ProductBalanceDto;
import com.capstone.restservice.repository.ProductBalanceRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class MockProductBalanceRepository implements ProductBalanceRepository {

    private final List<ProductBalanceDto> productBalanceDtos;

    private int findAllInvocationCount;

    public MockProductBalanceRepository(List<ProductBalanceDto> productBalanceDtos) {
        this.productBalanceDtos = productBalanceDtos;
        findAllInvocationCount = 0;
    }

    @Override
    public List<ProductBalanceDto> findAll() {
        findAllInvocationCount++;
        return productBalanceDtos;
    }

    @Override
    public List<ProductBalanceDto> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ProductBalanceDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ProductBalanceDto> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(ProductBalanceDto entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProductBalanceDto> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ProductBalanceDto> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ProductBalanceDto> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ProductBalanceDto> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ProductBalanceDto> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<ProductBalanceDto> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ProductBalanceDto getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends ProductBalanceDto> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ProductBalanceDto> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ProductBalanceDto> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ProductBalanceDto> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProductBalanceDto> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ProductBalanceDto> boolean exists(Example<S> example) {
        return false;
    }

    public int getFindAllInvocationCount() {
        return findAllInvocationCount;
    }
}
