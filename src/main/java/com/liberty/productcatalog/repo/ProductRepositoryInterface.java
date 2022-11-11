package com.liberty.productcatalog.repo;

import com.liberty.productcatalog.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryInterface extends CrudRepository<Product, Long> {

}
