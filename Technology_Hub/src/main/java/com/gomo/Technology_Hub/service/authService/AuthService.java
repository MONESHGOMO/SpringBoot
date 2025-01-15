package com.gomo.Technology_Hub.service.authService;

import com.gomo.Technology_Hub.dto.SignUpRequest;
import com.gomo.Technology_Hub.dto.UserDto;

public interface AuthService {

    public UserDto createUser (SignUpRequest signUpRequest);

    boolean hasUserWithEmail(String email);
}
