package com.example.pet_shop.model.order;

import com.example.pet_shop.model.client.unregister.UnregisterClient;
import com.example.pet_shop.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
   /*@ManyToMany
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id_fk"),
    inverseJoinColumns = @JoinColumn(name = "product_id_fk"))
    List<Product> products;*/


   @ManyToOne
   @JoinColumn(name = "unregister_client_id_fk")
    UnregisterClient unregisterClient;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Double getOrderSumm() {
        return orderSumm;
    }

    public void setOrderSumm(Double orderSumm) {
        this.orderSumm = orderSumm;
    }

    public String getOrderDeliveryType() {
        return orderDeliveryType;
    }

    public void setOrderDeliveryType(String orderDeliveryType) {
        this.orderDeliveryType = orderDeliveryType;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public UnregisterClient getUnregisterClient() {
        return unregisterClient;
    }

    public void setUnregisterClient(UnregisterClient unregisterClient) {
        this.unregisterClient = unregisterClient;
    }
}
