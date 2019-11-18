package com.example.pet_shop.model.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class ProductCategory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Column(name = "product_category_name")
    private String productCategoryName;

    @Column(name = "product_category_eng_name")
    private String productCategoryEngName;

    @JsonIgnore
    @ManyToMany(mappedBy = "productCategories")
    List<ProductSubcategory> productSubcategories;


    @ManyToMany
    @JoinTable(name = "product_type_category", joinColumns = {@JoinColumn(name = "product_category_id_fk")},
    inverseJoinColumns = @JoinColumn(name = "product_type_id_fk"))
    List<ProductType> productTypes;
}
