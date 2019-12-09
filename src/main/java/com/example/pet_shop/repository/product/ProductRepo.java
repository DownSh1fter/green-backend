package com.example.pet_shop.repository.product;

import com.example.pet_shop.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface ProductRepo extends JpaRepository<Product, Long> {



  //  List<Product> findAllByProductSubcategory_ProductSubcategoryEngName(String subCategory);



   // List<Product> findByProductSubcategory_ProductCategories_ProductCategoryEngName_And_ProductTypes_ProductTypeEngName(String category, String type);
  /* List<Product> findByProductSubcategoryProductCategoriesProductTypesProductTypeEngName(String type);
   List<Product> findByProductSubcategory_ProductCategories_ProductTypesProductTypeEngName_AndProductSubcategoryProductCategoriesProductCategoryEngName(String type, String category);
    List<Product> findByProductSubcategory_ProductCategories_ProductTypesProductTypeEngName_AndProductSubcategoryProductCategoriesProductCategoryEngName_AndProductSubcategoryProductSubcategoryEngName(String type, String category, String subCategory);*/

    List<Product> findByProductType_ProductTypeEngName(String type);
    List<Product> findByProductType_ProductTypeEngNameAndProductCategory_ProductCategoryEngName(String type, String category);
  List<Product> findByProductType_ProductTypeEngNameAndProductCategory_ProductCategoryEngNameAndProductSubcategory_ProductSubcategoryEngName(String type, String category, String subCategory);


    List<Product> findByOrderProducts_Order_OrderId(Long id);

}
