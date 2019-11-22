package com.example.pet_shop.repository.product;

import com.example.pet_shop.model.product.ProductMaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMakerRepo extends JpaRepository<ProductMaker, Long> {
}
