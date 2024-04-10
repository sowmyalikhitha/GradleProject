package com.project.productdata.service;

import java.util.List;
import com.project.productdata.eo.ProductEo;

public interface ProductService {
	ProductEo createProduct(ProductEo product);
    ProductEo getProduct(Long productId);
    List<ProductEo> getAllProducts();
}


