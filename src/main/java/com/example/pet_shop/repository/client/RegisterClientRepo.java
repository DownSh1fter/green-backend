package com.example.pet_shop.repository.client;

import com.example.pet_shop.model.client.Role;
import com.example.pet_shop.model.client.register.RegisterClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RegisterClientRepo extends JpaRepository<RegisterClient, Long>{


    Optional<RegisterClient> findByUserName(String userName);
   /* default void saveClient(RegisterClient user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepo.getOne(1));
        user.setRoles(roles);

        user.setRoles(new HashSet<>(roleRepo.findAll()));
        userRepo.save(user);
    }*/

    Boolean existsByUserName(String username);

    Boolean existsByEmail(String email);

}
