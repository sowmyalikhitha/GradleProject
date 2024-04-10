package com.project.productdata.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.project.productdata.eo.ProductEo;

public interface ProductController {
	  ResponseEntity<ProductEo> getProduct(Long productId);
	  ResponseEntity<ProductEo> createProduct(ProductEo product);
	  List<ProductEo> getAllProducts();
	  ResponseEntity<String> healthCheckGetProduct(Long productId);
}
