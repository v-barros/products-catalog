package com.liberty.productcatalog.usecases.searchproducts;

import com.liberty.productcatalog.entity.Product;
import com.liberty.productcatalog.repo.ProductRepositoryInterface;
import com.liberty.productcatalog.usecases.searchproducts.dto.SearchProductsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SearchProductsUseCase {
    @Autowired
    private ProductRepositoryInterface productRepositoryInterface;

    public Page<SearchProductsDto> searchProducts(String keyword, Integer pageNum, Integer resultsPerPage){
        Pageable pageable = PageRequest.of(pageNum, resultsPerPage);
        return productRepositoryInterface.search(keyword, pageable).map(SearchProductsDto::new);
    }
}
