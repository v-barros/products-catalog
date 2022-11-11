package com.liberty.productcatalog.usecases.getproductdetails;

import com.liberty.productcatalog.usecases.getproductdetails.dto.ProductDetailsDto;
import com.liberty.productcatalog.entity.Product;
import com.liberty.productcatalog.repo.ProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductDetailsUseCase {

    @Autowired
    private ProductRepositoryInterface productRepositoryInterface;

    public ProductDetailsDto getProduct (Long productId){

        Optional<Product> product= productRepositoryInterface.findById(productId);
        return new ProductDetailsDto(product.orElseThrow());
    }

}
