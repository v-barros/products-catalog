package com.liberty.productcatalog.repo.impl;

import com.liberty.productcatalog.entity.Product;
import com.liberty.productcatalog.repo.ProductRepositoryInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepositoryInterface {



    @Override
    public <S extends Product> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }


    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Product> findAll() {
        return null;
    }

    @Override
    public Iterable<Product> findAllById(Iterable<Long> longs) {
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
    public void delete(Product entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Page<Product> search(String keyword, Pageable pageable) {
        return null;
    }
}
