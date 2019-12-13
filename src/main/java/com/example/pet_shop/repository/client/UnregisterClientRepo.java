package com.example.pet_shop.repository.client;

import com.example.pet_shop.model.client.unregister.UnregisterClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnregisterClientRepo extends JpaRepository<UnregisterClient, Long > {
}
