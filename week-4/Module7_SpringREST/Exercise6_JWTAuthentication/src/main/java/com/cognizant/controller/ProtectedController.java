package com.cognizant.controller;

import com.cognizant.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This controller has protected endpoints that require JWT token
@RestController
@RequestMapping("/api/protected")
public class ProtectedController {

    @Autowired
    private JWTService jwtService;

    // Step 1: Get the token from Authorization header
    // Step 2: Validate the token
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestHeader("Authorization") String authHeader) {
        // Authorization header is expected to be: Bearer <token>
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return new ResponseEntity<>("Missing or invalid Authorization header", HttpStatus.UNAUTHORIZED);
        }
        String token = authHeader.substring(7);
        if (jwtService.validateToken(token)) {
            String username = jwtService.extractUsername(token);
            return new ResponseEntity<>("Hello " + username + "! You accessed a protected endpoint with valid JWT token!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid or expired token", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Welcome to Dashboard! This is a protected resource.";
    }
}
