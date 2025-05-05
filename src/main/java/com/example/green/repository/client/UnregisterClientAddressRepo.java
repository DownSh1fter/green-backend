package com.example.green.repository.client;

import com.example.green.model.client.unregister.ClientAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnregisterClientAddressRepo extends JpaRepository<ClientAddress, Long> {
}
