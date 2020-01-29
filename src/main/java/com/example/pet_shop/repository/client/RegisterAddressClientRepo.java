package com.example.pet_shop.repository.client;

import com.example.pet_shop.model.client.register.RegisterClientAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterAddressClientRepo extends JpaRepository<RegisterClientAddress, Long> {
}
