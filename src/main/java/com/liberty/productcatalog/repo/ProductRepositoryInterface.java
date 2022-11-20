package com.liberty.productcatalog.repo;

import com.liberty.productcatalog.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryInterface extends CrudRepository<Product, Long> {
    @Query(value = "SELECT * FROM tproducts WHERE MATCH (name,description) AGAINST (?1)",nativeQuery = true)
    public Page<Product> search(String keyword, Pageable pageable);

}
