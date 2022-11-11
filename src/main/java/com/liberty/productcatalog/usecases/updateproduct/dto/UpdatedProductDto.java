package com.liberty.productcatalog.usecases.updateproduct.dto;

import com.liberty.productcatalog.entity.Product;

public class UpdatedProductDto {

    private Long id;

    public UpdatedProductDto(Product product){
        this.id = product.getId();
    }
    public UpdatedProductDto(Long id) {
        this.id = id;
    }

    public UpdatedProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
