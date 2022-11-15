package com.liberty.productcatalog.usecases.getproductslist;

import com.liberty.productcatalog.repo.ProductRepositoryInterface;
import com.liberty.productcatalog.usecases.getproductslist.dto.ProductDtoToList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetProductsListUseCase {

    @Autowired
    private ProductRepositoryInterface productRepositoryInterface;

    public List<ProductDtoToList> getProductsList(){
        List<ProductDtoToList> productList = new ArrayList<>();
        productRepositoryInterface.findAll().forEach(product -> productList.add(new ProductDtoToList(product)));
        return productList;
    }
}
