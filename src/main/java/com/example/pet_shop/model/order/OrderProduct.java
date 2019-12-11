package com.example.pet_shop.model.order;


import com.example.pet_shop.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "order_product")
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
      /*@MapsId("order_id_fk")*/
      @JoinColumn(name = "order_id_fk", referencedColumnName = "order_id", insertable = false, updatable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
      Order order;

      //  @JsonIgnore
    @ManyToOne
    /*@MapsId("product_id_fk")*/
    @JoinColumn(name = "product_id_fk", referencedColumnName = "product_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Product product;


    @Column(name = "product_quantity")
    private int productQuantity;

    @Column(name = "product_summ")
    private Double productSumm;

    @Column(name = "product_size")
    private String productSize;

    public OrderProductKey getId() {
        return id;
    }

    public void setId(OrderProductKey id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Double getProductSumm() {
        return productSumm;
    }

    public void setProductSumm(Double productSumm) {
        this.productSumm = productSumm;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", productQuantity=" + productQuantity +
                ", productSumm=" + productSumm +
                ", productSize='" + productSize + '\'' +
                '}';
    }
}
