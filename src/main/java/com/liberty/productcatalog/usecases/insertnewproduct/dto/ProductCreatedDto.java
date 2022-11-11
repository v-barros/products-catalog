package com.liberty.productcatalog.usecases.insertnewproduct.dto;

public class ProductCreatedDto {

    private Long id;

    public ProductCreatedDto(Long id) {
        this.id = id;
    }

    public ProductCreatedDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
