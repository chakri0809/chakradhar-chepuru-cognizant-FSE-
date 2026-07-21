package com.cognizant.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

// This service creates and validates JWT tokens
// JWT = JSON Web Token - it is like a digital ID card for the user
@Service
public class JWTService {

    // Secret key used to sign tokens - injected from application.properties
    @Value("${jwt.secret}")
    private String secret;

    // Token expiration in milliseconds
    @Value("${jwt.expiration}")
    private long expiration;

    // Step 1: Create the JWT token with username and expiry time
    // Step 2: Sign it with our secret key so no one can fake it
    public String generateToken(String username) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        System.out.println("JWT Token generated for: " + username);
        return token;
    }

    // This reads the username from inside the JWT token
    public String extractUsername(String token) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Check if token is valid and not expired
    public boolean validateToken(String token) {
        try {
            extractUsername(token);
            System.out.println("Token validated successfully");
            return true;
        } catch (Exception ex) {
            System.out.println("Token validation failed: " + ex.getMessage());
            return false;
        }
    }
}
