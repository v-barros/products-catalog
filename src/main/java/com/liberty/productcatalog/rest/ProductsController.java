package com.liberty.productcatalog.rest;


import com.liberty.productcatalog.usecases.getproductdetails.GetProductDetailsUseCase;
import com.liberty.productcatalog.usecases.getproductdetails.dto.ProductDetailsDto;
import com.liberty.productcatalog.usecases.insertnewproduct.InsertNewProductUseCase;
import com.liberty.productcatalog.usecases.insertnewproduct.dto.ProductCreatedDto;
import com.liberty.productcatalog.usecases.insertnewproduct.form.ProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {

    @Autowired
    private GetProductDetailsUseCase getProductDetailsUseCase;

    @Autowired
    private InsertNewProductUseCase insertNewProductUseCase;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDetailsDto> getProduct(@PathVariable Long productId){
        try {
            ProductDetailsDto product = getProductDetailsUseCase.getProduct(productId);
            return ResponseEntity.ok(product);
        }catch (NoSuchElementException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProductCreatedDto> insertProduct(@RequestBody @Valid  ProductForm productForm, UriComponentsBuilder builder){
        try{
            ProductCreatedDto productCreatedDto = insertNewProductUseCase.insertNew(productForm);
            URI uri = builder.path("/v1/products/{productId}").buildAndExpand(productCreatedDto.getId()).toUri();
            return ResponseEntity.created(uri).body(productCreatedDto);
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }

    }
}
