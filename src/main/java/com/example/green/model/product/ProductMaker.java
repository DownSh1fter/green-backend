package com.example.green.model.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_maker")
public class ProductMaker {

    @Id
    @Column(name = "product_maker_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productMakerId;

    @Column(name = "product_maker_name")
    private String productMakerName;

    @Column(name = "product_maker_eng_name")
    private String productMakerEngName;

    @Column(name = "product_maker_address")
    private String productMakerAddress;

    @OneToMany(mappedBy = "productMaker")
    @JsonIgnore
    private List<Product> products;
}
