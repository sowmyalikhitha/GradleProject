package com.project.productdata.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.productdata.eo.ProductEo;
import com.project.productdata.service.ProductService;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductControllerImp implements ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	 
	@Autowired
    private ProductService productService;
	
	@GetMapping("/{id}")
    public ResponseEntity<ProductEo> getProduct( @PathVariable Long id) {
        logger.info("Fetching product with ID: {}",id);
        ProductEo productEo = productService.getProduct(id);
        if (productEo != null) {
            logger.info("Product found with ID: {} ",id);
            return ResponseEntity.ok(productEo);
        } else {
            logger.warn("Product not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }
	
	 @GetMapping("/all")
	    public List<ProductEo> getAllProducts() {
	        logger.info("Received GET request to retrieve all products");
	        List<ProductEo> products = productService.getAllProducts();
	        logger.info("Retrieved {} products", products.size());
	        return products;
	    }
	
	@PostMapping
    public ResponseEntity<ProductEo> createProduct(@RequestBody ProductEo product) {
        logger.info("Received POST request to create product");
        ProductEo createdProduct = productService.createProduct(product);
        if (createdProduct != null && createdProduct.getId() != null) {
            logger.info("Product created successfully with ID: {}", createdProduct.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } else {
            logger.error("Error occurred while creating product");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
	@GetMapping("/health/get/{productId}")
	public ResponseEntity<String> healthCheckGetProduct(@PathVariable Long productId) {
	    try {
	        ProductEo product = productService.getProduct(productId);
	        if (product != null) {
	            return ResponseEntity.ok("Health check for get product endpoint is successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                                 .body("Health check for get product endpoint failed: Product not found");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("Health check for get product endpoint failed: " + e.getMessage());
	    }
}
}
