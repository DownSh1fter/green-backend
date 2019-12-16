package com.example.pet_shop.repository.client;

import com.example.pet_shop.model.client.unregister.ClientAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnregisterClientAddressRepo extends JpaRepository<ClientAddress, Long> {
}
