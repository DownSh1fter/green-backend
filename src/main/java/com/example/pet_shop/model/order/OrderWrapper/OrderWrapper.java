package com.example.pet_shop.model.order.OrderWrapper;


import com.example.pet_shop.model.order.Order;
import com.example.pet_shop.model.order.OrderProduct;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrderWrapper {

    private Order order;
   /* private OrderProduct orderProduct;*/
    private LinkedHashMap<Long, Integer> map;


    public OrderWrapper() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

  /*  public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }*/

    public LinkedHashMap<Long, Integer> getMap() {
        return map;
    }

    public void setMap(LinkedHashMap<Long, Integer> map) {
        this.map = map;
    }
}
