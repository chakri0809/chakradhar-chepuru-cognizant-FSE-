package com.cognizant.controller;

import org.springframework.web.bind.annotation.*;

// Exercise 3 - Hello World REST Service. This shows basic REST API concepts
@RestController
@RequestMapping("/api")
public class HelloWorldController {

    // Basic GET endpoint - returns simple hello message
    @GetMapping("/hello")
    public String hello() {
        return "Hello World! This is my REST API";
    }

    // @PathVariable means the name comes from the URL like /hello/Rahul
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello " + name + "! Welcome to Spring REST API";
    }

    // @RequestParam means the name comes as ?name=Rahul in the URL
    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Good Morning " + name + "! Have a great day!";
    }

    // POST endpoint - used to send data to server
    // @RequestBody means we receive data in the request body
    @PostMapping("/hello")
    public String postHello(@RequestBody String message) {
        return "You sent: " + message;
    }

    // Simple status endpoint
    @GetMapping("/status")
    public String status() {
        return "Service is UP and running!";
    }
}
