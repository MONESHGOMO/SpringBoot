package com.gomocodes.CRUD.controller;


import com.gomocodes.CRUD.entity.Users;
import com.gomocodes.CRUD.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UsersController {

  @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public List<Users> getAllUsers() {
         return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUsersByID(@PathVariable  Long id){
        return usersService.getUsersByID(id);
    }


    @PostMapping("/postData")
    public Users createUsers(@RequestBody Users users){
        return usersService.createUsers(users);
    }

    @PutMapping("/{id}")
    public Users updateUsers(@PathVariable Long id ,@RequestBody Users userDetails){
        Users users=usersService.getUsersByID(id);
        if(users!=null){
            users.setName(userDetails.getName());
            users.setEmail(userDetails.getEmail());
            users.setContact(userDetails.getContact());
            return usersService.createUsers(users);
        }
        return null;

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        usersService.deleteUsersByID(id);
        return "User deleted with id: " + id;
    }







}
