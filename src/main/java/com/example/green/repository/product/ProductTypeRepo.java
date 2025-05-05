package com.example.green.repository.product;

import com.example.green.model.product.ProductCategory;
import com.example.green.model.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductTypeRepo extends JpaRepository<ProductType, Long> {
    //


}
