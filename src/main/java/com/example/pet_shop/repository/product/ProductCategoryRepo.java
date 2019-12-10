package com.example.pet_shop.repository.product;

import com.example.pet_shop.model.product.ProductCategory;
import com.example.pet_shop.model.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {

   /* @Query(value = "select product_category_name from product_category as pc" +
            "inner join product_type_category as ptc"+
            "on ptc.product_category_id_fk=pc.product_category_id" +
            "inner join product_type as pt" +
            "on ptc.product_type_id_fk=pt.product_type_id" +
            "where pt.product_type_eng_name=:type", nativeQuery = true)
     List<ProductCategory> findAllByProductTypes(@Param("type") String type);*/


/*   @Query("select productName from ProductCategory pc where pc.productTypes.productTypeName = :productType")
   List<ProductCategory> findAllByProductTypes(@Param("productType") String productType);*/
    //@Query("select pc from ProductCategory where pc.productTypes.productTypeName = :type")
    List<ProductCategory> findByProductTypeC_ProductTypeEngName( String type);
    //
}
