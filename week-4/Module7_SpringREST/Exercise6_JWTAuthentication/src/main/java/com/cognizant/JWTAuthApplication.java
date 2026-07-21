package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Exercise 6 - Create authentication service that returns JWT - Mandatory Hands-on
@SpringBootApplication
public class JWTAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JWTAuthApplication.class, args);
        System.out.println("==================================");
        System.out.println("=== JWT Authentication Service ===");
        System.out.println("==================================");
        System.out.println("POST /api/auth/login");
        System.out.println("Body: {username: admin, password: admin123}");
        System.out.println("Body: {username: rahul, password: rahul123}");
        System.out.println("Body: {username: priya, password: priya123}");
        System.out.println("GET /api/auth/test - Public endpoint");
        System.out.println("GET /api/auth/validate?token=YOUR_TOKEN");
        System.out.println("==================================");
    }
}
