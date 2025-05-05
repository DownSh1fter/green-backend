package com.example.green.repository.product;

import com.example.green.model.product.ProductSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSubcategoryRepo extends JpaRepository<ProductSubcategory, Long> {

    List<ProductSubcategory> findAllByProductCategoryS_ProductCategoryEngName(String category);
    //

}
