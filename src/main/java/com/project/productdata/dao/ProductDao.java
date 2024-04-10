package com.project.productdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.productdata.eo.ProductEo;

public interface ProductDao extends JpaRepository<ProductEo, Long>{

}
