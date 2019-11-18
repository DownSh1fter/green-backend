package com.example.pet_shop.model.product;


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
public class ProductSubcategory {

    @Id
    @Column(name = "product_subcategory_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productSubcategoryId;

    @Column(name = "product_subcategory_name")
    private String productSubcategoryName;

    @Column(name = "product_subcategory_name_eng")
    private String productSubcategoryEngName;


    @OneToMany(mappedBy = "productSubcategory")
    @JsonIgnore
     private List<Product> products;

    @ManyToMany
    @JoinTable(name = "product_category_subcategory", joinColumns = { @JoinColumn(name = "product_subcategory_id_fk")},
    inverseJoinColumns = @JoinColumn(name = "product_category_id_fk"))
    List<ProductCategory> productCategories;

}
