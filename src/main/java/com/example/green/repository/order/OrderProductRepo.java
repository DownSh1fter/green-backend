package com.example.green.repository.order;

import com.example.green.model.order.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
}
