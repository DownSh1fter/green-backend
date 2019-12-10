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


    @OneToMany(mappedBy = "productCategory")
    @JsonIgnore
    private List<Product> products;

   /* @JsonIgnore
    @ManyToMany(mappedBy = "productCategories")
    List<ProductSubcategory> productSubcategories;*/

   @JsonIgnore
    @OneToMany(mappedBy = "productCategoryS")
    List<ProductSubcategory> productSubcategories;


    @ManyToOne
    @JoinColumn(name = "product_type_id_fk")
    ProductType productTypeC;


    /*@ManyToMany
    @JoinTable(name = "product_type_category", joinColumns = {@JoinColumn(name = "product_category_id_fk")},
    inverseJoinColumns = @JoinColumn(name = "product_type_id_fk"))
    List<ProductType> productTypes;*/

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getProductCategoryEngName() {
        return productCategoryEngName;
    }

    public void setProductCategoryEngName(String productCategoryEngName) {
        this.productCategoryEngName = productCategoryEngName;
    }

    public List<ProductSubcategory> getProductSubcategories() {
        return productSubcategories;
    }

    public void setProductSubcategories(List<ProductSubcategory> productSubcategories) {
        this.productSubcategories = productSubcategories;
    }

   /* public List<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<ProductType> productTypes) {
        this.productTypes = productTypes;

          }*/

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductType getProductTypeC() {
        return productTypeC;
    }

    public void setProductTypeC(ProductType productTypeC) {
        this.productTypeC = productTypeC;
    }
}
