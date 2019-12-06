package com.example.pet_shop.repository.order;

import com.example.pet_shop.model.order.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
}
