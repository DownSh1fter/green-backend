package com.example.pet_shop.repository.order;

import com.example.pet_shop.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {


   // Order findByOrderProducts_Product(Long id);

}
