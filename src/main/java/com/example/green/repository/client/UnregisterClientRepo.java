package com.example.green.repository.client;

import com.example.green.model.client.unregister.UnregisterClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnregisterClientRepo extends JpaRepository<UnregisterClient, Long > {
}
