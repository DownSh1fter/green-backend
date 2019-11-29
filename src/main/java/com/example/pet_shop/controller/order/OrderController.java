package com.example.pet_shop.controller.order;


import com.example.pet_shop.model.order.Order;
import com.example.pet_shop.model.product.Product;
import com.example.pet_shop.repository.order.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petshop.by")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    OrderRepo orderRepo;


    @GetMapping(value = "/admin/orders")
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }



    @PostMapping(value = "/admin/orders")
    public void createOrder(@RequestBody Order order){
        orderRepo.save(order);
    }

}
