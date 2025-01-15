package com.gomo.Technology_Hub.controller;

import com.gomo.Technology_Hub.dto.AuthenticationRequest;
import com.gomo.Technology_Hub.dto.SignUpRequest;
import com.gomo.Technology_Hub.dto.UserDto;
import com.gomo.Technology_Hub.model.AppUser;
import com.gomo.Technology_Hub.repository.UserRepository;
import com.gomo.Technology_Hub.service.CustomUserDetailsService;
import com.gomo.Technology_Hub.service.authService.AuthService;
import com.gomo.Technology_Hub.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    final String HEAD_STRING = "Authorization";
    final String TOKEN_PREFIX = "Bearer ";

    @Autowired
    private AuthService authService;

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, CustomUserDetailsService customUserDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtUtil = jwtUtil;
    }



    @PostMapping("/authenticate")
    public void createAuthenticatedToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse httpServletResponse) throws IOException, JSONException {
        logger.info("Received authentication request for username: {}", authenticationRequest.getUsername());

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            logger.info("Authentication successful for username: {}", authenticationRequest.getUsername());
        } catch (BadCredentialsException e) {
            logger.error("Authentication failed for username: {}", authenticationRequest.getUsername(), e.getMessage());
            throw new BadCredentialsException("Incorrect username or password");
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        Optional<AppUser> optionalUser = userRepository.findFirstByEmail(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        if (optionalUser.isPresent()) {
            logger.info("User found: {}, generating JWT", optionalUser.get().getEmail());
            httpServletResponse.getWriter().write(new JSONObject()
                    .put("userId", optionalUser.get().getId())
                    .put("role", optionalUser.get().getRole())
                    .toString());

            httpServletResponse.addHeader("Access-Control-Expose-Headers","Authorization");
            httpServletResponse.addHeader("Access-Control-Allow-Headers","Authorization,X-PINGOTHER,Origin" + "X-Request-With,Content-Type,Accept,X-Custom-header");

            httpServletResponse.addHeader(HEAD_STRING, TOKEN_PREFIX + jwt);
            logger.info("JWT added to response header for username: {}", authenticationRequest.getUsername());
        } else {
            logger.warn("User not found for username: {}", authenticationRequest.getUsername());
        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUpRequest(@RequestBody SignUpRequest signUpRequest) {
        logger.info("Received sign-up request for email: {}", signUpRequest.getEmail());

        if (authService.hasUserWithEmail(signUpRequest.getEmail())) {
            logger.warn("Sign-up attempt failed. User already exists for email: {}", signUpRequest.getEmail());
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
        }

        UserDto userDto = authService.createUser(signUpRequest);
        logger.info("New user created with email: {}", signUpRequest.getEmail());
        return new ResponseEntity<>("New user data added", HttpStatus.CREATED);
    }
}
