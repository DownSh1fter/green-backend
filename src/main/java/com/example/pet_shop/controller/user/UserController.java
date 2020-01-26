package com.example.pet_shop.controller.user;

import com.example.pet_shop.model.client.register.RegisterClient;
import com.example.pet_shop.repository.client.RegisterClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/petshop.by")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    RegisterClientRepo registerClientRepo;

    @GetMapping(value = "/user/{userName}")
    public Optional<RegisterClient> getUserByUserName(@PathVariable("userName") String userName){
        return registerClientRepo.findByUserName(userName);
    }
}
