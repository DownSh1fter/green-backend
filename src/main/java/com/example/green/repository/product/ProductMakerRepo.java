package com.example.green.repository.product;

import com.example.green.model.product.ProductMaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMakerRepo extends JpaRepository<ProductMaker, Long> {
    //
}
