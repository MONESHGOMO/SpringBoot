package com.gomo.Technology_Hub.service.authService;

import com.gomo.Technology_Hub.dto.SignUpRequest;
import com.gomo.Technology_Hub.dto.UserDto;
import com.gomo.Technology_Hub.enums.AppUserRole;
import com.gomo.Technology_Hub.model.AppUser;
import com.gomo.Technology_Hub.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation implements  AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser (SignUpRequest signUpRequest){
        AppUser user = new AppUser();

        user.setEmail(signUpRequest.getEmail());
        user.setUserName(signUpRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        user.setRole(AppUserRole.CUSTOMER);
        AppUser createdUser = userRepository.save(user);
        UserDto userDto= new UserDto();

        user.setId(createdUser.getId());
        return userDto;

    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }


    @PostConstruct
    public void createAdminAccount(){

        AppUser adminAccount = userRepository.findByRole(AppUserRole.ADMIN);
        if(adminAccount == null){
            AppUser user = new AppUser();
            user.setEmail("testadmin@gmail.com");
            user.setRole(AppUserRole.ADMIN);
            user.setUserName("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }
}
