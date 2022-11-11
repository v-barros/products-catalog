package com.liberty.productcatalog.repo;

import com.liberty.productcatalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositoryInterface extends CrudRepository<Product, Long> {

}
