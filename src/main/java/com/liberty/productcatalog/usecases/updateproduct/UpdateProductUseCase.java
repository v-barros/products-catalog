package com.liberty.productcatalog.usecases.updateproduct;

import com.liberty.productcatalog.entity.Product;
import com.liberty.productcatalog.repo.ProductRepositoryInterface;
import com.liberty.productcatalog.usecases.updateproduct.dto.UpdatedProductDto;
import com.liberty.productcatalog.usecases.updateproduct.form.ProductToUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductUseCase {

    @Autowired
    private ProductRepositoryInterface productRepositoryInterface;

    public UpdatedProductDto updateProduct(ProductToUpdateForm productToUpdateForm,Long productId){
        Optional<Product> optionalProduct = productRepositoryInterface.findById(productId);
        optionalProduct.get().setDescription(productToUpdateForm.getDescription());
        optionalProduct.get().setQuantityAvailable(productToUpdateForm.getQuantityAvailable());
        optionalProduct.get().setPrice(productToUpdateForm.getPrice());
        optionalProduct.get().setName(productToUpdateForm.getName());
        optionalProduct.get().setPhoto(productToUpdateForm.getPhoto());
        return new UpdatedProductDto(productRepositoryInterface.save(optionalProduct.get()));
    }
}
