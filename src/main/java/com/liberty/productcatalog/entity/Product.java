package com.liberty.productcatalog.entity;


import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name="tproducts")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private Integer quantityAvailable;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime creationDate;

    public Product(){}
    public Product(Long id, String name, String photo, String description, Double rating, Integer quantityAvailable, Double price, LocalDateTime creationDate) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.rating = rating;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate);
    }
}
