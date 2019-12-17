package com.example.pet_shop.controller.order;


import com.example.pet_shop.model.client.unregister.ClientAddress;
import com.example.pet_shop.model.client.unregister.UnregisterClient;
import com.example.pet_shop.model.order.Order;
import com.example.pet_shop.model.order.OrderProduct;
import com.example.pet_shop.model.order.OrderProductKey;
import com.example.pet_shop.model.order.OrderWrapper.OrderWrapper;
import com.example.pet_shop.model.product.Product;
import com.example.pet_shop.repository.client.UnregisterClientAddressRepo;
import com.example.pet_shop.repository.client.UnregisterClientRepo;
import com.example.pet_shop.repository.order.OrderProductRepo;
import com.example.pet_shop.repository.order.OrderRepo;
import com.example.pet_shop.repository.product.ProductRepo;
import com.example.pet_shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/petshop.by")
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

    @GetMapping(value = "/admin/orders")
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }



    @PostMapping(value = "/admin/orders")
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


        double summ = 0;
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
            OrderProduct orderProduct = new OrderProduct();


            Map<Long, Integer> map = orderWrapper.getMap();
            for (Map.Entry<Long, Integer> m: map.entrySet()) {
                System.out.println("-------------------");
                System.out.println(m.getKey() + " " + m.getValue());
            }

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
    public List<Product> getProductsByOrderId(@PathVariable Long id){
         return productRepo.findByOrderProducts_Order_OrderId(id);
    }


    @DeleteMapping(value = "/admin/orders/{id}")
        public void deleteOrder(@PathVariable long id){
            orderRepo.deleteById(id);
    }
}

