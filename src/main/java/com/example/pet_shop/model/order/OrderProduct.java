package com.example.pet_shop.model.order;


import com.example.pet_shop.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class OrderProduct {

    @EmbeddedId
    OrderProductKey id;
  /*  @Id
    @Column(name = "order_id_fk")
    private long orderIdFk;

    @Id
    @Column(name = "product_id_fk")
    private long productIdFk;*/


        @JsonIgnore
      @ManyToOne
      @MapsId("order_id_fk")
      @JoinColumn(name = "order_id_fk")
      Order order;

        @JsonIgnore
    @ManyToOne
    @MapsId("product_id_fk")
    @JoinColumn(name = "product_id_fk")
    Product product;


    @Column(name = "product_quantity")
    private int productQuantity;

    @Column(name = "product_summ")
    private Double productSumm;

}
