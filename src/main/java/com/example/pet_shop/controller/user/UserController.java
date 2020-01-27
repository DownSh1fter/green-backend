package com.example.pet_shop.controller.user;

import com.example.pet_shop.model.client.register.RegisterClient;
import com.example.pet_shop.repository.client.RegisterClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/petshop.by")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    RegisterClientRepo registerClientRepo;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = "/user/{userName}")
    public Optional<RegisterClient> getUserByUserName(@PathVariable("userName") String userName){

        return registerClientRepo.findByUserName(userName);
    }


    @PutMapping(value = "/user/change/{userName}")
    public void changeUserDetails(@RequestBody RegisterClient registerClient, @PathVariable("userName") String userName){
            Optional<RegisterClient> changedUser = registerClientRepo.findByUserName(userName);
            changedUser.ifPresent(changedUser1 -> {
                    changedUser1.setFirstName(registerClient.getFirstName());
                    changedUser1.setLastName(registerClient.getLastName());
                    changedUser1.setEmail(registerClient.getEmail());
                    changedUser1.setTel(registerClient.getTel());
                    changedUser1.setUserName(registerClient.getUserName());
                    changedUser1.setPassword(bCryptPasswordEncoder.encode(registerClient.getPassword()));
                    registerClientRepo.save(changedUser1);
            });


    }
}
