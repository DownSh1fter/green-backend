package com.example.green.controller.cart;

import com.example.green.model.product.Product;
import com.example.green.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/green.by")
@CrossOrigin(origins = "http://localhost:4200")

public class CartController {

    @Autowired
    CartService cartService;


    @GetMapping(value = "/cart")
    public List<Product> getCart(){
        return cartService.getCartList();
    }

    @PostMapping(value = "/cart")
    public Product addProductToCartList(@RequestBody Product product){
        cartService.addProductToList(product);
        return product;
    }


    @DeleteMapping(value ="/cart/{id}")
    public void deleteProductFromCartList(@PathVariable Long id){
        cartService.deleteProductFromCartList(id);
    }

}
