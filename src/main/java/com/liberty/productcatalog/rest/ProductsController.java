package com.liberty.productcatalog.rest;


import com.liberty.productcatalog.usecases.getproductdetails.GetProductDetailsUseCase;
import com.liberty.productcatalog.usecases.getproductdetails.dto.ProductDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {

    @Autowired
    private GetProductDetailsUseCase getProductDetailsUseCase;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDetailsDto> getProduct(@PathVariable Long productId){
        try {
            ProductDetailsDto product = getProductDetailsUseCase.getProduct(productId);
            return ResponseEntity.ok(product);
        }catch (NoSuchElementException ex){
            return ResponseEntity.notFound().build();
        }
    }
}
