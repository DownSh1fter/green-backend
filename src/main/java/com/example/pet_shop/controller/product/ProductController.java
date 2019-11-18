package com.example.pet_shop.controller.product;


import com.example.pet_shop.model.product.Product;
import com.example.pet_shop.model.product.ProductCategory;
import com.example.pet_shop.model.product.ProductType;
import com.example.pet_shop.repository.product.ProductCategoryRepo;
import com.example.pet_shop.repository.product.ProductRepo;
import com.example.pet_shop.repository.product.ProductTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/petshop.by")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProductTypeRepo productTypeRepo;

    @Autowired
    ProductCategoryRepo productCategoryRepo;

    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }


    @GetMapping(value = "/catalog", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductType> getAllTypes(){
        return productTypeRepo.findAll();
    }


    @GetMapping(value = "/catalog/{type}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductCategory> getCategoriesByType(@PathVariable String type){
        return productCategoryRepo.findAllByProductTypes(type);
    }
}
