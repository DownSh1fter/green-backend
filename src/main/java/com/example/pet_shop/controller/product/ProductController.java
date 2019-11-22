package com.example.pet_shop.controller.product;


import com.example.pet_shop.model.product.Product;
import com.example.pet_shop.model.product.ProductCategory;
import com.example.pet_shop.model.product.ProductSubcategory;
import com.example.pet_shop.model.product.ProductType;
import com.example.pet_shop.repository.product.ProductCategoryRepo;
import com.example.pet_shop.repository.product.ProductRepo;
import com.example.pet_shop.repository.product.ProductSubcategoryRepo;
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

    @Autowired
    ProductSubcategoryRepo productSubcategoryRepo;

    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }


    @GetMapping(value = "/catalog", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductType> getAllTypes(){
        return productTypeRepo.findAll();
    }

    //working
    @GetMapping(value = "/catalog/{type}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductCategory> getCategoriesByType(@PathVariable String type){
        return productCategoryRepo.findByProductTypes_productTypeEngName(type);
    }

    //TO-DO .....
    @GetMapping(value = "/catalog/product/{type}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductsByType(@PathVariable String type){
        return productRepo.findByProductSubcategoryProductCategoriesProductTypesProductTypeEngName(type);
    }

    //Working
    @GetMapping(value = "/catalog/{type}/{category}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductSubcategory> getSubcategoryByTypeAndCategory(@PathVariable String category){
        return productSubcategoryRepo.findAllByProductCategories_productCategoryEngName(category);

    }


   //TO-DO ....
    @GetMapping(value = "/catalog/product/{type}/{category}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getSubcategoryByTypeAndCategory(@PathVariable String category, @PathVariable String type){
        return productRepo.findByProductSubcategory_ProductCategories_ProductTypesProductTypeEngName_AndProductSubcategoryProductCategoriesProductCategoryEngName(type, category);

    }

    @GetMapping(value = "/catalog/product/{type}/{category}/{subCategory}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductsBySubcategoryName(@PathVariable String subCategory, @PathVariable String type, @PathVariable String category){
        return productRepo.findByProductSubcategory_ProductCategories_ProductTypesProductTypeEngName_AndProductSubcategoryProductCategoriesProductCategoryEngName_AndProductSubcategoryProductSubcategoryEngName(type, category, subCategory);
    }


    /*@GetMapping(value = "/catalog/{type}/{category}/{subCategory}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductSubcategory> getSubcategoryByTypeAndCategory(@PathVariable String subCategory){
        return productSubcategoryRepo.findAllByProductCategories_productCategoryEngName(category);

    }*/


}
