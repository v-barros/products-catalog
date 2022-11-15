package com.liberty.productcatalog.usecases.addrating.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RatingForm {
    @NotNull
    private Long id;

    @NotNull
    @Min(0)
    @Max(5)
    private Integer rating;

    public RatingForm(Long id, Integer rating) {
        this.id = id;
        this.rating = rating;
    }

    public RatingForm() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
