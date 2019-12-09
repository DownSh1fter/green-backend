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
public class ProductType {
//JOHN.k – OT (Lyrics)

    @Id
    @Column(name = "product_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productTypeId;

    @Column(name = "product_type_name")
    private String productTypeName;

    @Column(name = "product_type_eng_name")
    private String productTypeEngName;

    @JsonIgnore
    @ManyToMany(mappedBy = "productTypes")
    List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "productType")
    @JsonIgnore
    private List<Product> products;


    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductTypeEngName() {
        return productTypeEngName;
    }

    public void setProductTypeEngName(String productTypeEngName) {
        this.productTypeEngName = productTypeEngName;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }
}
