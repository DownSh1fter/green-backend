package com.example.pet_shop.controller.order;


import com.example.pet_shop.model.order.Order;
import com.example.pet_shop.model.product.Product;
import com.example.pet_shop.repository.order.OrderRepo;
import com.example.pet_shop.repository.product.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petshop.by")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    OrderRepo orderRepo;


    @Autowired
    ProductRepo productRepo;


    @GetMapping(value = "/admin/orders")
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }



    @PostMapping(value = "/admin/orders")
    public void createOrder(@RequestBody Order order){
        orderRepo.save(order);
    }


    @GetMapping(value = "/admin/orders/{id}")
    public List<Product> getProductsByOrderId(@PathVariable Long id){
         return productRepo.findByOrderProducts_Order_OrderId(id);
    }

}

