package com.liberty.productcatalog.usecases.addrating;


import com.liberty.productcatalog.entity.Product;
import com.liberty.productcatalog.repo.ProductRepositoryInterface;
import com.liberty.productcatalog.usecases.addrating.form.RatingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddRatingUseCase {

    @Autowired
    private ProductRepositoryInterface productRepositoryInterface;

    public Double addRating(RatingForm ratingForm){
        Optional<Product> optionalProduct =  productRepositoryInterface.findById(ratingForm.getId());
        if(!optionalProduct.isPresent()) {
            throw new IllegalArgumentException();
        }

        Product product = optionalProduct.get();
        product.setTotalRatings(product.getTotalRatings()+1);
        product.setRatingsSum(product.getRatingsSum()+ratingForm.getRating());

        product.setRating( ((double)product.getRatingsSum()/((double)product.getTotalRatings())));

        productRepositoryInterface.save(product);


        return product.getRating();

    }
}
