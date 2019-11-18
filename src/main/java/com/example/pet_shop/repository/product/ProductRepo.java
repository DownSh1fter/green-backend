package com.example.pet_shop.repository.product;

import com.example.pet_shop.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface ProductRepo extends JpaRepository<Product, Long> {
}
