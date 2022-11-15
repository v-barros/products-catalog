package com.liberty.productcatalog.usecases.getproductslist.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.liberty.productcatalog.entity.Product;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

public class ProductDtoToList {

    private Long id;

    private String name;

    private String photo;

    private Double rating;

    private Double price;

    public ProductDtoToList(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.photo = product.getPhoto();
        this.rating = product.getRating();
        this.price = product.getPrice();
    }
    public ProductDtoToList(Long id, String name, String photo, Double rating, Double price) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.rating = rating;
        this.price = price;
    }

    public ProductDtoToList() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDtoToList that = (ProductDtoToList) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
