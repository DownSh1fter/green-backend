package com.example.green.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.green.model.product.Product;
import com.example.green.model.product.ProductCategory;
import com.example.green.model.product.ProductMaker;
import com.example.green.model.product.ProductType;
import com.example.green.repository.product.*;

@RestController
@RequestMapping("/green.by")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProductMakerRepo productMakerRepo;

    @Autowired
    ProductTypeRepo productTypeRepo;

    @Autowired
    ProductCategoryRepo productCategoryRepo;

    @Autowired
    ProductSubcategoryRepo productSubcategoryRepo;

   /* @PreAuthorize("hasRole('ROLE_ADMIN')")*/
    @PostMapping(value = "/admin/add")
    public void addProduct(@RequestBody Product product){
       /* ProductMaker productMaker = productMakerRepo.getOne((long) 2);
        product.setProductMaker(productMaker);*/
      /*  ProductType productType = productTypeRepo.getOne((long)2);
        ProductCategory productCategory = productCategoryRepo.getOne((long)1);
        productType.getProductCategories().add(productCategory);
        productCategory.getProductTypes().add(productType);
        productCategory.getProductSubcategories().add(product.getProductSubcategory());
        product.getProductSubcategory().getProductCategories().add(productCategory);*/
        this.productRepo.save(product);
    }
}
