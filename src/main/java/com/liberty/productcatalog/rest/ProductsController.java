package com.liberty.productcatalog.rest;


import com.liberty.productcatalog.usecases.addrating.AddRatingUseCase;
import com.liberty.productcatalog.usecases.addrating.form.RatingForm;
import com.liberty.productcatalog.usecases.getproductdetails.GetProductDetailsUseCase;
import com.liberty.productcatalog.usecases.getproductdetails.dto.ProductDetailsDto;
import com.liberty.productcatalog.usecases.getproductslist.GetProductsListUseCase;
import com.liberty.productcatalog.usecases.getproductslist.dto.ProductDtoToList;
import com.liberty.productcatalog.usecases.insertnewproduct.InsertNewProductUseCase;
import com.liberty.productcatalog.usecases.insertnewproduct.dto.NewProductDto;
import com.liberty.productcatalog.usecases.insertnewproduct.form.NewProductForm;
import com.liberty.productcatalog.usecases.searchproducts.SearchProductsUseCase;
import com.liberty.productcatalog.usecases.updateproduct.UpdateProductUseCase;
import com.liberty.productcatalog.usecases.updateproduct.dto.UpdatedProductDto;
import com.liberty.productcatalog.usecases.updateproduct.form.ProductToUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {

    @Autowired
    private GetProductDetailsUseCase getProductDetailsUseCase;

    @Autowired
    private InsertNewProductUseCase insertNewProductUseCase;

    @Autowired
    private UpdateProductUseCase updateProductUseCase;

    @Autowired
    private GetProductsListUseCase getProductsListUseCase;

    @Autowired
    private AddRatingUseCase addRatingUseCase;

    @Autowired
    private SearchProductsUseCase searchProductsUseCase;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDetailsDto> getProduct(@PathVariable Long productId){
        try {
            ProductDetailsDto product = getProductDetailsUseCase.getProduct(productId);
            return ResponseEntity.ok(product);
        }catch (NoSuchElementException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<NewProductDto> insertProduct(@RequestBody @Valid NewProductForm newProductForm, UriComponentsBuilder builder){

        try{
            NewProductDto newProductDto = insertNewProductUseCase.insertNew(newProductForm);
            URI uri = builder.path("/v1/products/{productId}").buildAndExpand(newProductDto.getId()).toUri();
            return ResponseEntity.created(uri).body(newProductDto);
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{productId}")
    @Transactional
    public ResponseEntity<UpdatedProductDto> updateProduct(@PathVariable Long productId, @RequestBody @Valid ProductToUpdateForm productToUpdateForm,UriComponentsBuilder builder){
        try{
            UpdatedProductDto updatedProductDto = updateProductUseCase.updateProduct(productToUpdateForm,productId);
            URI uri = builder.path("/v1/products/{productId}").buildAndExpand(updatedProductDto.getId()).toUri();
            return ResponseEntity.ok(updatedProductDto);
        }catch (Exception ex ){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List> getProductsList(){
        try{
            List <ProductDtoToList> productList = getProductsListUseCase.getProductsList();
            return ResponseEntity.ok(productList);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{productId}/ratings")
    @Transactional
    public ResponseEntity<Double> addNewRating(@PathVariable Long productId, @Valid @RequestBody RatingForm ratingForm){
        try{
            if(ratingForm.getId() != productId)
                throw new IllegalArgumentException();
            Double newRating = addRatingUseCase.addRating(ratingForm);
            return ResponseEntity.ok(newRating);
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List> searchProducts(@RequestParam("keyword") String keyword, @RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size",required = false, defaultValue = "10") int size){
            try{
                Page pageVar = searchProductsUseCase.searchProducts(keyword,page,size);
                return ResponseEntity.ok(pageVar.toList());
            }catch (Exception ex ){
                return ResponseEntity.badRequest().build();
            }

    }
}
