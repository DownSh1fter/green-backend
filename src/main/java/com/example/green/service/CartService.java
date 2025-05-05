package com.example.green.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.green.model.product.Product;
import com.example.green.repository.product.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class CartService {

    @Autowired
    ProductRepo productRepo;

    private List<Product> cartList = new ArrayList<>();

    public  void addProductToList(Product product){
        cartList.add(product);
    }

    public void deleteProductFromCartList(Long id){
        Long productID = productRepo.getOne(id).getProductId();
        ListIterator<Product> productIterator = cartList.listIterator();
        /*while (productIterator.hasNext()){
            Product product = productIterator.next();
            if (productID.equals(product.getProductId())){   динэш (работающий ахуеть)
                productIterator.remove();
                break;
            }
        }*/
       /* while (productIterator.hasNext()){
            if((productIterator.next().getProductId() == productID)){
                productIterator.remove();
            }
        }*/

        cartList.removeIf(p -> p.getProductId()==productID);

/*        Predicate<Product> pr = product -> product.getProductId() == productID; СУКА НЕ УДАЛЯЙ БЛЯТЬ ИЛИ ВИИБУ
        Stream.of(productIterator).forEach(pi -> pr.test(pi.next()));*/
        /*if (productIterator.hasNext()){
            if((productIterator.next().getProductId() == productID)){ итератор дэлетэ
                productIterator.remove();
            }
        }*/
    }

    public List<Product> getCartList(){
        return cartList;
    }
}
