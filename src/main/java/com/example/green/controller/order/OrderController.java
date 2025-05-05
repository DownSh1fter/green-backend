package com.example.green.controller.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.green.model.client.register.RegisterClient;
import com.example.green.model.client.register.RegisterClientAddress;
import com.example.green.model.client.unregister.ClientAddress;
import com.example.green.model.client.unregister.UnregisterClient;
import com.example.green.model.order.Order;
import com.example.green.model.order.OrderProduct;
import com.example.green.model.order.OrderProductKey;
import com.example.green.model.order.OrderWrapper.OrderWrapper;
import com.example.green.model.product.Product;
import com.example.green.repository.client.RegisterAddressClientRepo;
import com.example.green.repository.client.RegisterClientRepo;
import com.example.green.repository.client.UnregisterClientAddressRepo;
import com.example.green.repository.client.UnregisterClientRepo;
import com.example.green.repository.order.OrderProductRepo;
import com.example.green.repository.order.OrderRepo;
import com.example.green.repository.product.ProductRepo;
import com.example.green.service.CartService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/green.by")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    OrderRepo orderRepo;


    @Autowired
    ProductRepo productRepo;

    @Autowired
    CartService cartService;

    @Autowired
    OrderProductRepo orderProductRepo;


    @Autowired
    UnregisterClientRepo unregisterClientRepo;

    @Autowired
    UnregisterClientAddressRepo unregisterClientAddressRepo;

    @Autowired
    RegisterAddressClientRepo registerAddressClientRepo;

    @Autowired
    RegisterClientRepo registerClientRepo;


    @RequestMapping(value = "/admin/orderss")
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }


    @PostMapping(value = "/add/orders")
    public void createOrder(@RequestBody OrderWrapper orderWrapper){
        // work
        /*double summ = 0;
        OrderProductKey productKey = new OrderProductKey();
        Order order = orderWrapper.getOrder();

        UnregisterClient unregisterClient = order.getUnregisterClient();
        ClientAddress unregisterClientAddress = unregisterClient.getClientAddress();
        List<OrderProduct> orderProducts = new ArrayList<>();
        List<Product> products = cartService.getCartList();

        order.setOrderSumm(1000.00);
        order.setOrderDeliveryType(order.getOrderDeliveryType());
        order.setOrderDescription(order.getOrderDescription());

        unregisterClientAddressRepo.save(unregisterClientAddress);
        unregisterClientRepo.save(unregisterClient);
        order.setUnregisterClient(unregisterClient);
        orderRepo.save(order);




        productKey.setOrderIdFk(order.getOrderId());

        for (Product p: products) {
            OrderProduct orderProduct = orderWrapper.getOrderProduct();

            productKey.setProductIdFk(p.getProductId());
            System.out.println("------------------");
            orderProduct.setOrder(order);
            orderProduct.setId(productKey);
            orderProduct.setProduct(p);
            orderProduct.setProductQuantity(orderProduct.getProductQuantity());
            orderProduct.setProductSize(p.getProductSize());
            orderProduct.setProductSumm(p.getProductPrice());


            orderProducts.add(orderProduct);
            orderProductRepo.saveAll(orderProducts);


            System.out.println(orderProducts.toString());


            order.setOrderProducts(orderProducts);
            summ+=p.getProductPrice()*orderProduct.getProductQuantity();

        }
        order.setOrderSumm(summ);
        orderRepo.save(order);
        products.clear();
*/


        double summ = 0.00;
        OrderProductKey productKey = new OrderProductKey();
        Order order = orderWrapper.getOrder();


        UnregisterClient unregisterClient = order.getUnregisterClient();
        ClientAddress unregisterClientAddress = unregisterClient.getClientAddress();
        List<OrderProduct> orderProducts = new ArrayList<>();
        List<Product> products = cartService.getCartList();

        order.setOrderSumm(summ);
      //  order.setOrderDeliveryType(order.getOrderDeliveryType());
    //    order.setOrderDescription(order.getOrderDescription());

        unregisterClientAddressRepo.save(unregisterClientAddress);
        unregisterClientRepo.save(unregisterClient);
        order.setUnregisterClient(unregisterClient);
        orderRepo.save(order);


        LinkedHashMap<Long, Integer> map = orderWrapper.getMap();

        map.forEach((i,j) -> System.out.println("**************** " + i + " " + j));
        System.out.println(map.size());

        productKey.setOrderIdFk(order.getOrderId());

           for (Product p: products) {
            OrderProduct orderProduct = new OrderProduct();
            productKey.setProductIdFk(p.getProductId());
            System.out.println("------------------");
            orderProduct.setOrder(order);
            orderProduct.setId(productKey);
            orderProduct.setProduct(p);

            orderProduct.setProductQuantity(map.get(p.getProductId()));
            orderProduct.setProductSize(p.getProductSize());
            orderProduct.setProductSumm(p.getProductPrice());


            orderProducts.add(orderProduct);
            orderProductRepo.saveAll(orderProducts);


            System.out.println(orderProducts.toString());


            order.setOrderProducts(orderProducts);
            summ+=p.getProductPrice()*orderProduct.getProductQuantity();

        }
        order.setOrderSumm(summ);
        orderRepo.save(order);
        products.clear();


    }


    @GetMapping(value = "/admin/orders/{id}")
     @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Product> getProductsByOrderId(@PathVariable Long id){
         return productRepo.findByOrderProducts_Order_OrderId(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/admin/orders/{id}")
        public void deleteOrder(@PathVariable long id){
            orderRepo.deleteById(id);
    }


    @PostMapping(value = "/admin/order")
    public void createOrderForRegisterUser(@RequestBody OrderWrapper orderWrapper){
        double summ = 0;
        OrderProductKey productKey = new OrderProductKey();
        Order order = orderWrapper.getOrder();


        RegisterClient registerClient = order.getRegisterClient();
      //  RegisterClientAddress registerClientAddress = registerClient.getRegisterClientAddress();
        List<OrderProduct> orderProducts = new ArrayList<>();
        List<Product> products = cartService.getCartList();

        order.setOrderSumm(summ);
        order.setOrderDeliveryType(order.getOrderDeliveryType());
        order.setOrderDescription(order.getOrderDescription());

      //  registerAddressClientRepo.save(registerClientAddress);

      //  order.setRegisterClient(registerClientRepo.findByUserName(registerClient.getUserName())); ?????????????????
        orderRepo.save(order);


        LinkedHashMap<Long, Integer> map = orderWrapper.getMap();

        map.forEach((i,j) -> System.out.println("**************** " + i + " " + j));
        System.out.println(map.size());

        productKey.setOrderIdFk(order.getOrderId());

        for (Product p: products) {
            OrderProduct orderProduct = new OrderProduct();
            productKey.setProductIdFk(p.getProductId());
            System.out.println("------------------");
            orderProduct.setOrder(order);
            orderProduct.setId(productKey);
            orderProduct.setProduct(p);

            orderProduct.setProductQuantity(map.get(p.getProductId()));
            orderProduct.setProductSize(p.getProductSize());
            orderProduct.setProductSumm(p.getProductPrice());


            orderProducts.add(orderProduct);
            orderProductRepo.saveAll(orderProducts);


            System.out.println(orderProducts.toString());


            order.setOrderProducts(orderProducts);
            summ+=p.getProductPrice()*orderProduct.getProductQuantity();

        }
        order.setOrderSumm(summ);
        orderRepo.save(order);
        products.clear();


    }

}

