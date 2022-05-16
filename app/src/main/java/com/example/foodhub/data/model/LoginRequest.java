package com.example.foodhub.data.model;

public class LoginRequest {
    private String email;
    private String pass;
    private String type;
    private String method;

    public LoginRequest(String email, String pass, String type, String method) {
        this.email = email;
        this.pass = pass;
        this.type = type;
        this.method = method;
    }
}
