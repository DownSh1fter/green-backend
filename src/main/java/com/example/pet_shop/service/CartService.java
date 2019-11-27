package com.example.pet_shop.service;


import com.example.pet_shop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private List<Product> cartList = new ArrayList<>();

    public  void addProductToList(Product product){
        cartList.add(product);
    }

    public List<Product> getCartList(){
        return cartList;
    }
}
