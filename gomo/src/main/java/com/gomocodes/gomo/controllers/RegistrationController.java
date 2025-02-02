package com.gomocodes.gomo.controllers;


import com.gomocodes.gomo.models.MyUser;
import com.gomocodes.gomo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @PostMapping("/register/user")
    public MyUser addUser(@RequestBody MyUser addUser) {
        addUser.setPassword(passwordEncoder.encode(addUser.getPassword()));
        addUser.setRole(addUser.getRole().toUpperCase(Locale.ROOT));
        return repo.save(addUser);

    }
}