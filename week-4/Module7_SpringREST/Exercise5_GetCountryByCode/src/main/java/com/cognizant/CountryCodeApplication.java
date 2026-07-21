package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Exercise 5 - REST Get country based on country code - Mandatory Hands-on
@SpringBootApplication
public class CountryCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountryCodeApplication.class, args);
        System.out.println("=== Exercise 5: Get Country by Country Code Service Started ===");
        System.out.println("Test URL: http://localhost:8084/api/countries/IN");
        System.out.println("Test URL: http://localhost:8084/api/countries/US");
        System.out.println("Test URL: http://localhost:8084/api/countries/JP");
    }
}
