package com.project.productdata.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.productdata.bo.ProductBo;
import com.project.productdata.eo.ProductEo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class ProductServiceImp implements ProductService{
    
	private Logger logger = LoggerFactory.getLogger(ProductServiceImp.class);
	
	@Autowired
	private ProductBo productBo;
	
	@Override
    public ProductEo createProduct(ProductEo product) {
        logger.info("Creating product: {}", product);
        ProductEo createdProduct = productBo.createProduct(product);
        logger.info("Product created successfully with ID: {}", createdProduct.getId());
        return createdProduct;
    }

    @Override
    public ProductEo getProduct(Long productId) {
        logger.info("Retrieving product with ID: {}", productId);
        ProductEo product = productBo.getProduct(productId);
        if (product != null) {
            logger.info("Product retrieved successfully: {}", product);
        } else {
            logger.info("Product with ID {} not found", productId);
        }
        return product;
    }

    @Override
    public List<ProductEo> getAllProducts() {
        logger.info("Retrieving all products");
        List<ProductEo> products = productBo.getAllProducts();
        logger.info("Retrieved {} products", products.size());
        return products;
    }
}
