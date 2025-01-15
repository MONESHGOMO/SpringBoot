package com.gomo.Technology_Hub.filters;

import com.gomo.Technology_Hub.service.CustomUserDetailsService;
import com.gomo.Technology_Hub.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * This class is a custom filter used for JWT-based authentication.
 * It validates the JWT token present in the request and sets the user details
 * in the Spring Security context if the token is valid.
 *
 * Purpose of the Class:
 * - Extract the JWT token from the `Authorization` header.
 * - Validate the token using the `JwtUtil` class.
 * - Retrieve the user details from the database (or another source) using `CustomUserDetailsService`.
 * - Authenticate the user and set the authentication in the Spring Security context.
 * - Pass the request to the next filter in the chain if the token is valid.
 *
 * If this class is not present:
 * - JWT tokens will not be validated for incoming requests.
 * - Spring Security will not be able to authenticate users based on JWT tokens.
 * - All secured endpoints will deny access unless other authentication mechanisms are used.
 */

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailsService userDetailsService; // Service to load user details from the database.

    @Autowired
    private JwtUtil jwtUtil; // Utility class to handle JWT token generation, validation, and parsing.

    /**
     * This method is invoked for every incoming HTTP request.
     * It performs the following:
     * - Extracts the JWT token from the `Authorization` header.
     * - Validates the token and retrieves the username.
     * - Loads user details and sets the authentication in the SecurityContext if the token is valid.
     * - Passes the request to the next filter in the chain.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Extract the Authorization header from the HTTP request.
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null; // Stores the username extracted from the token.
        String token = null;    // Stores the JWT token.

        // Check if the Authorization header is present and starts with "Bearer".
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
            token = authorizationHeader.substring(7); // Extract the token (skip "Bearer ").
            username = jwtUtil.extractUserName(token); // Extract the username from the token.
        }

        // Check if the username is not null and the SecurityContext does not already have authentication.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Load the user details using the username extracted from the token.
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Validate the token against the user details.
            if (jwtUtil.validateToken(token, userDetails)) {
                // Create an authentication token for the user.
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set the authentication token in the SecurityContext.
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // Pass the request to the next filter in the chain.
        filterChain.doFilter(request, response);
    }
}
