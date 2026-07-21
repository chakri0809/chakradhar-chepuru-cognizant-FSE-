package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Exercise 4 - REST Country Web Service
@SpringBootApplication
public class CountryApplication {

    // Main method - start the app and print a friendly message
    public static void main(String[] args) {
        SpringApplication.run(CountryApplication.class, args);
        System.out.println("=== Country REST Service Started on port 8083 ===");
    }
}
