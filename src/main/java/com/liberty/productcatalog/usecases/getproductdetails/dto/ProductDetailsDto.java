package com.liberty.productcatalog.usecases.getproductdetails.dto;

import com.liberty.productcatalog.entity.Product;
import java.time.LocalDateTime;

public class ProductDetailsDto {
    private Long id;

    private String name;

    private String photo;

    private String description;

    private Long rating;

    private Long sellerId;

    private Integer quantityAvailable;

    private Long price;

    private LocalDateTime creationDate;


    public ProductDetailsDto (Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.photo = product.getPhoto();
        this.description = product.getDescription();
        this.rating = product.getRating();
        this.sellerId = product.getSellerId();
        this.quantityAvailable = product.getQuantityAvailable();
        this.price = product.getPrice();
        this.creationDate = product.getCreationDate();
    }
}
