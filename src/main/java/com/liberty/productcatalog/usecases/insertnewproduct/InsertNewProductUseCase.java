package com.liberty.productcatalog.usecases.insertnewproduct;

import com.liberty.productcatalog.entity.Product;
import com.liberty.productcatalog.repo.ProductRepositoryInterface;
import com.liberty.productcatalog.usecases.insertnewproduct.dto.ProductCreatedDto;
import com.liberty.productcatalog.usecases.insertnewproduct.form.ProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class InsertNewProductUseCase {
    @Autowired
    private ProductRepositoryInterface productRepositoryInterface;

    public ProductCreatedDto insertNew (ProductForm productForm){
        Product product = productForm.formToProduct();
        product.setCreationDate(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
        product.setRating(0.0);
        Product savedProduct = productRepositoryInterface.save(product);
        return new ProductCreatedDto(savedProduct.getId());
    }
}
