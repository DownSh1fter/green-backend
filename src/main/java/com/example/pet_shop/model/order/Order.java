package com.example.pet_shop.model.order;

import com.example.pet_shop.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "orders")
public class Order {


    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "order_summ")
    private Double orderSumm;

    @Column(name = "order_delivery_type")
    private String orderDeliveryType;

    @Column(name = "order_description")
    private String orderDescription;

    @OneToMany(mappedBy = "order")
    List<OrderProduct> orderProducts;



}
