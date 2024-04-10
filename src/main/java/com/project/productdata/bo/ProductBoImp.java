package com.project.productdata.bo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.project.productdata.dao.ProductDao;
import com.project.productdata.eo.ProductEo;

@Slf4j
@AllArgsConstructor
@Component
public class ProductBoImp implements ProductBo {
	
	Logger logger = LoggerFactory.getLogger(ProductBoImp.class);
	
	@Autowired
    private ProductDao productDao;

	@Override
    public ProductEo createProduct(ProductEo product) {
        logger.info("Creating product: {}", product);
        ProductEo createdProduct = productDao.save(product);
        logger.info("Product created successfully with ID: {}", createdProduct.getId());
        return createdProduct;
    }

    @Override
    public ProductEo getProduct(Long productId) {
        logger.info("Retrieving product with ID: {}", productId);
        ProductEo product = productDao.findById(productId).orElse(null);
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
        List<ProductEo> products = productDao.findAll();
        logger.info("Retrieved {} products", products.size());
        return products;
    }
}




