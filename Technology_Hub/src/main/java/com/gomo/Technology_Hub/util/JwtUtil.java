package com.gomo.Technology_Hub.util;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Secret key used for signing and verifying JWTs. This should be a Base64-encoded string.
    public static final String SECRET = "NJKEFNOQENFQN";

    /**
     * Generates a JWT token for the provided username.
     * @param username the username to include in the token
     * @return the generated JWT token
     */
    public String generateToken(String username) {
        // Create an empty claims map to include additional data in the token if needed
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    /**
     * Creates a JWT token with the provided claims and subject (username).
     * @param claims additional data to include in the token
     * @param username the subject of the token (usually the username)
     * @return the created JWT token
     */
    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims) // Set custom claims
                .setSubject(username) // Set the subject (username)
                .setIssuedAt(new Date(System.currentTimeMillis())) // Set the issued time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // Set expiration time (30 minutes)
                .signWith(getSignKey(), SignatureAlgorithm.HS256) // Sign the token using the secret key and HS256 algorithm
                .compact(); // Build and return the token
    }

    /**
     * Decodes the secret key and generates a signing key.
     * @return the signing key
     */
    public Key getSignKey() {
        // Decode the Base64-encoded secret key and generate an HMAC-SHA key
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Extracts the username (subject) from the provided JWT token.
     * @param token the JWT token
     * @return the username (subject) stored in the token
     */
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts a specific claim from the JWT token using a function.
     * @param token the JWT token
     * @param claimsResolver a function to extract the desired claim
     * @param <T> the type of the claim
     * @return the extracted claim
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token); // Parse the token to extract all claims
        return claimsResolver.apply(claims); // Apply the function to extract the desired claim
    }

    /**
     * Parses the token and extracts all claims.
     * @param token the JWT token
     * @return all claims stored in the token
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey()) // Set the signing key for verification
                .build()
                .parseClaimsJws(token) // Parse the token
                .getBody(); // Extract the claims body
    }

    /**
     * Checks if the token is expired.
     * @param token the JWT token
     * @return true if the token is expired, false otherwise
     */
    private Boolean isTokenExpiration(String token) {
        return extractExpiration(token).before(new Date()); // Compare the expiration date with the current date
    }

    /**
     * Extracts the expiration date from the token.
     * @param token the JWT token
     * @return the expiration date of the token
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration); // Use the claims resolver to get the expiration claim
    }

    /**
     * Validates the token by checking its username and expiration status.
     * @param token the JWT token
     * @param userDetails the user details to validate against
     * @return true if the token is valid, false otherwise
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUserName(token); // Extract the username from the token
        // Check if the token's username matches the provided user details and ensure it's not expired
        return (username.equals(userDetails.getUsername()) && !isTokenExpiration(token));
    }
}
