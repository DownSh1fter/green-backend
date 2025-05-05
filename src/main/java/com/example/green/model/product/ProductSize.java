package com.example.green.model.product;


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
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_size_id")
    private Long productSizeId;

    @Column(name = "product_size_value")
    private String productSizeValue;

    @JsonIgnore
    @ManyToMany(mappedBy = "productSizes")
    List<Product> products;

    @Column(name = "product_price")
    Double productPrice;


   /*@OneToMany(mappedBy = "productSize")
    List<ProductJoinSize> productJoinSizes;*/




   /* @ManyToMany
    @JoinTable(name = "product_size_price", joinColumns = @JoinColumn(name = "product_size_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "product_price_id_fk"))
    List<ProductPrice> productPrices;*/

}
