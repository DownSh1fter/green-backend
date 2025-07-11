package com.example.green.model.product;

import com.example.green.model.order.Order;
import com.example.green.model.order.OrderProduct;
import com.example.green.request.SignupRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    /*@JsonIgnore*/
    @ManyToOne
    @JoinColumn(name = "product_subcategory_id_fk")
    private ProductSubcategory productSubcategory;

    /*@JsonIgnore*/
    @ManyToOne
    @JoinColumn(name = "product_category_id_fk")
    private ProductCategory productCategory;

    /*@JsonIgnore*/
    @ManyToOne
    @JoinColumn(name = "product_type_id_fk")
    private ProductType productType;

 /*   @Column(name = "product_type_id")
    private String productTypeName;

    @Column(name = "product_category_id")
    private String productCategoryId;

    @Column(name = "product_subcategory_id")
    private String productSubCategoryId;*/


    @ManyToMany
    @JoinTable(name = "product_join_size", joinColumns = @JoinColumn(name = "product_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "product_size_id_fk"))
    List<ProductSize> productSizes;

  /*  @OneToMany(mappedBy = "product")
    List<ProductJoinSize> productJoinSizes;*/

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderProduct> orderProducts;

 /*  @JsonIgnore
   @ManyToMany(mappedBy = "products")
    List<Order> orders;*/




    @Transient
    private String productSize;


    @Transient
    private Double productPrice;

    public String getProductImage() {
        return productImage;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductEngName() {
        return productEngName;
    }

    public void setProductEngName(String productEngName) {
        this.productEngName = productEngName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductStructure() {
        return productStructure;
    }

    public void setProductStructure(String productStructure) {
        this.productStructure = productStructure;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public ProductMaker getProductMaker() {
        return productMaker;
    }

    public void setProductMaker(ProductMaker productMaker) {
        this.productMaker = productMaker;
    }

    public ProductSubcategory getProductSubcategory() {
        return productSubcategory;
    }

    public void setProductSubcategory(ProductSubcategory productSubcategory) {
        this.productSubcategory = productSubcategory;
    }

    public List<ProductSize> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productEngName, product.productEngName) &&
                Objects.equals(productDescription, product.productDescription) &&
                Objects.equals(productStructure, product.productStructure) &&
                Objects.equals(productImage, product.productImage) &&
                Objects.equals(productMaker, product.productMaker) &&
                Objects.equals(productSubcategory, product.productSubcategory) &&
                Objects.equals(productCategory, product.productCategory) &&
                Objects.equals(productType, product.productType) &&
                Objects.equals(productSizes, product.productSizes) &&
                Objects.equals(orderProducts, product.orderProducts) &&
                Objects.equals(productSize, product.productSize) &&
                Objects.equals(productPrice, product.productPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productEngName, productDescription, productStructure, productImage, productMaker, productSubcategory, productCategory, productType, productSizes, orderProducts, productSize, productPrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productEngName='" + productEngName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productStructure='" + productStructure + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productMaker=" + productMaker +
                ", productSubcategory=" + productSubcategory +
                ", productSizes=" + productSizes +
                ", orderProducts=" + orderProducts +
                ", productSize='" + productSize + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
