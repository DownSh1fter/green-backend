package com.example.pet_shop.controller.admin;


import com.example.pet_shop.model.product.Product;
import com.example.pet_shop.model.product.ProductMaker;
import com.example.pet_shop.repository.product.ProductMakerRepo;
import com.example.pet_shop.repository.product.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/petshop.by")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProductMakerRepo productMakerRepo;


    @PostMapping(value = "/admin/add")
    public void addProduct(@RequestBody Product product){
       // ProductMaker productMaker = productMakerRepo.getOne(p)
        this.productRepo.save(product);
    }
}
