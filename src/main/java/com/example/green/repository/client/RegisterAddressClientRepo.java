package com.example.green.repository.client;

import com.example.green.model.client.register.RegisterClientAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterAddressClientRepo extends JpaRepository<RegisterClientAddress, Long> {
}
