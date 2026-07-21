package com.cognizant.controller;

import com.cognizant.model.LoginRequest;
import com.cognizant.model.LoginResponse;
import com.cognizant.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// This controller handles login requests and returns JWT tokens
// When user logs in with correct credentials we give them a JWT token
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JWTService jwtService;

    // In real project these would come from database with encrypted passwords
    // For this learning exercise we use hardcoded users
    private Map<String, String> users = new HashMap<>();

    public AuthController() {
        users.put("admin", "admin123");
        users.put("rahul", "rahul123");
        users.put("priya", "priya123");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Step 1: Get username and password from request
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        System.out.println("Login attempt: " + username);

        // Step 2: Check if username exists and password is correct
        if (users.containsKey(username) && users.get(username).equals(password)) {
            // Step 3: Generate JWT token for valid user
            String token = jwtService.generateToken(username);
            // Step 4: Send token back to user
            LoginResponse resp = new LoginResponse(token, username, "Login successful!");
            System.out.println("Login successful for: " + username);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } else {
            System.out.println("Login failed for: " + username);
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }

    // This endpoint checks if a given JWT token is valid
    @GetMapping("/validate")
    public String validateToken(@RequestParam String token) {
        boolean valid = jwtService.validateToken(token);
        if (valid) {
            return "Token is VALID. Username: " + jwtService.extractUsername(token);
        } else {
            return "Token is INVALID or EXPIRED";
        }
    }

    // Public test endpoint - no token needed
    @GetMapping("/test")
    public String testEndpoint() {
        return "JWT Auth Service is working! Use POST /api/auth/login to get token";
    }
}
