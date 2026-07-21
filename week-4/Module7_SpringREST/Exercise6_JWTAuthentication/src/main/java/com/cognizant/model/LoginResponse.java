package com.cognizant.model;

// This class holds the JWT token we send back after successful login
public class LoginResponse {

    // This is the JWT token the user will use for future requests
    private String token;
    private String username;
    private String message;

    public LoginResponse() {
    }

    public LoginResponse(String token, String username, String message) {
        this.token = token;
        this.username = username;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
