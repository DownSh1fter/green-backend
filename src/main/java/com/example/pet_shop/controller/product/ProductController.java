package com.example.pet_shop.controller.product;


import com.example.pet_shop.model.product.*;
import com.example.pet_shop.repository.product.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

    @Autowired
    ProductMakerRepo productMakerRepo;


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
        return productCategoryRepo.findByProductTypeC_ProductTypeEngName(type);
    }

    //TO-DO .....
    @GetMapping(value = "/catalog/product/{type}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductsByType(@PathVariable String type){
        return productRepo.findByProductType_ProductTypeEngName(type);
    }

    //Working
    @GetMapping(value = "/catalog/{type}/{category}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductSubcategory> getSubcategoryByTypeAndCategory(@PathVariable String category){
        return productSubcategoryRepo.findAllByProductCategoryS_ProductCategoryEngName(category);

    }


   //TO-DO ....
    @GetMapping(value = "/catalog/product/{type}/{category}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getSubcategoryByTypeAndCategory(@PathVariable String category, @PathVariable String type){
        return productRepo.findByProductType_ProductTypeEngNameAndProductCategory_ProductCategoryEngName(type, category);

    }

    @GetMapping(value = "/catalog/product/{type}/{category}/{subCategory}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductsBySubcategoryName(@PathVariable String subCategory, @PathVariable String type, @PathVariable String category){
        return productRepo.findByProductType_ProductTypeEngNameAndProductCategory_ProductCategoryEngNameAndProductSubcategory_ProductSubcategoryEngName(type, category, subCategory);
    }

    /*@GetMapping(value = "/catalog/{type}/{category}/{subCategory}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductSubcategory> getSubcategoryByTypeAndCategory(@PathVariable String subCategory){
        return productSubcategoryRepo.findAllByProductCategories_productCategoryEngName(category);
//
    }*/





    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImageAsByteArray(HttpServletResponse response, @PathVariable("id") Long id) throws IOException {
        Product product = productRepo.getOne(id);
       // System.out.println("--------" + product.getProductImage());
        InputStream in = new FileInputStream(new File("D://pet_shop/images/" + product.getProductImage()));
       // System.out.println(product.getProductImage());
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }


    @RequestMapping(value = "/makers")
    public List<ProductMaker> getAllProductMakers(){
        return productMakerRepo.findAll();
    }


    @RequestMapping(value = "/categories")
    public List<ProductCategory> getAllCategories(){
        return productCategoryRepo.findAll();
    }

    @RequestMapping(value = "/subCategories")
    public List<ProductSubcategory> getAllSubCategories(){
        return productSubcategoryRepo.findAll();
    }

}
