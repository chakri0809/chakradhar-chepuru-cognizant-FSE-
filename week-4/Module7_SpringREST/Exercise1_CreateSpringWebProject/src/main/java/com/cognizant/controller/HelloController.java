package com.cognizant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This controller handles web requests. @RestController means this class handles HTTP requests and returns data directly
@RestController
@RequestMapping("/api")
public class HelloController {

    // This method runs when someone visits /api/hello
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World! My first Spring REST API is working!";
    }

    // This method runs when someone visits /api/welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Cognizant Digital Nurture 5.0!";
    }

    // This method returns your name
    @GetMapping("/myname")
    public String myName() {
        // Replace [Your Name] with your actual name if you like
        return "My name is [Your Name] and I am learning Spring REST";
    }
}
