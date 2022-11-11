package com.liberty.productcatalog.usecases.getproductdetails.dto;

import com.liberty.productcatalog.entity.Product;
import java.time.LocalDateTime;

public class ProductDetailsDto {
    private Long id;

    private String name;

    private String photo;

    private String description;

    private Double rating;

    private Integer quantityAvailable;

    private Double price;

    private LocalDateTime creationDate;


    public ProductDetailsDto (Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.photo = product.getPhoto();
        this.description = product.getDescription();
        this.rating = product.getRating();
        this.quantityAvailable = product.getQuantityAvailable();
        this.price = product.getPrice();
        this.creationDate = product.getCreationDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
