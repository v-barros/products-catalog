package com.liberty.productcatalog.usecases.insertnewproduct.form;

import com.liberty.productcatalog.entity.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductForm {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String photo;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    private Integer quantityAvailable;

    private Double price;

    public ProductForm(){}

    public ProductForm(String name, String photo, String description, Integer quantityAvailable, Double price) {
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
    }

    public Product formToProduct(){
        Product product =  new Product();
        product.setName(name);
        product.setPhoto(photo);
        product.setDescription(description);
        product.setQuantityAvailable(quantityAvailable);
        product.setPrice(price);
        return product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
