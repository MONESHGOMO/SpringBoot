package com.gomocodes.CRUD.service;


import com.gomocodes.CRUD.entity.Users;
import com.gomocodes.CRUD.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;


    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public Users getUsersByID(Long id){
        return usersRepository.findById(id).orElse(null);
    }

    public Users createUsers(Users users){
        return usersRepository.save(users);

    }
    public void deleteUsersByID(Long id){
        usersRepository.deleteById(id);
    }


}
