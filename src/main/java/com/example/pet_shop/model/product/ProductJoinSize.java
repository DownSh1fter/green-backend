/*
package com.example.pet_shop.model.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_join_size")
public class ProductJoinSize implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_join_size_id")
    private long productJoinSizeId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id_fk")
    Product product;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_size_id_fk")
    ProductSize productSize;

    @Column(name = "product_price")
    private Double productPrice;

}
*/
