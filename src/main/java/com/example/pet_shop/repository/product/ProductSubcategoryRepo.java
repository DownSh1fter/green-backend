package com.example.pet_shop.repository.product;

import com.example.pet_shop.model.product.ProductSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSubcategoryRepo extends JpaRepository<ProductSubcategory, Long> {

    List<ProductSubcategory> findAllByProductCategories_productCategoryEngName(String category);
    //

}
