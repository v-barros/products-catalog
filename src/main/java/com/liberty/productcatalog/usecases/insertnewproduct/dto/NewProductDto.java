package com.liberty.productcatalog.usecases.insertnewproduct.dto;

public class NewProductDto {

    private Long id;

    public NewProductDto(Long id) {
        this.id = id;
    }

    public NewProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
