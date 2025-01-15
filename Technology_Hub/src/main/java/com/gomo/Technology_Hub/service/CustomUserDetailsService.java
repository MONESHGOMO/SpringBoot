package com.gomo.Technology_Hub.service;

import com.gomo.Technology_Hub.model.AppUser;
import com.gomo.Technology_Hub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {



    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AppUser> optionalUser = userRepository.findFirstByEmail(username); // e-mail
        if(optionalUser.isEmpty()) throw new UsernameNotFoundException("user not found " + username);
        return new org.springframework.security.core.userdetails.User(optionalUser.get().getEmail(),optionalUser.get().getPassword(),new ArrayList<>());
    }
}
