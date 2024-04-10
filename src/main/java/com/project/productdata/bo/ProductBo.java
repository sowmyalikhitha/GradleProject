package com.project.productdata.bo;

import java.util.List;
import com.project.productdata.eo.ProductEo;

public interface ProductBo{
    ProductEo createProduct(ProductEo product);
    ProductEo getProduct(Long productId);
    List<ProductEo> getAllProducts();
}

