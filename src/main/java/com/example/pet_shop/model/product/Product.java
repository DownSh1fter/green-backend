package com.example.pet_shop.model.product;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {


    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_eng_name")
    private String productEngName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_structure")
    private String productStructure;

    @Column(name = "product_image")
    private String productImage;

    @ManyToOne
    @JoinColumn(name = "product_maker_id_fk")
    private ProductMaker productMaker;

    @ManyToOne
    @JoinColumn(name = "product_subcategory_id_fk")
    private ProductSubcategory productSubcategory;


    @ManyToMany
    @JoinTable(name = "product_product_size", joinColumns = @JoinColumn(name = "product_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "product_size_id_fk"))
    List<ProductSize> productSizes;


}
