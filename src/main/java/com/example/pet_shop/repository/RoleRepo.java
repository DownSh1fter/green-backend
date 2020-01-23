package com.example.pet_shop.repository;

import com.example.pet_shop.model.client.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String name);
}
