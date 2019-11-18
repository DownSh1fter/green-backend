package com.example.pet_shop.controller.product;


import com.example.pet_shop.model.product.Product;
import com.example.pet_shop.repository.product.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/petshop.by")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @GetMapping(value = "/catalog", produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
}
