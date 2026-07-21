package com.cognizant.model;

// This class holds the username and password sent by user during login
public class LoginRequest {

    // Username provided by user
    private String username;

    // Password provided by user
    private String password;

    // Empty constructor
    public LoginRequest() {
    }

    // All-arg constructor
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
