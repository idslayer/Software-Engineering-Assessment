package com.example.bemediasearch.payload.resquest;

public class RegisterRequest {
    private String username;
    private String fullName;
    private String password;

    public RegisterRequest(String username, String fullName, String password) {
        this.username = username;
        this.fullName = fullName;
        this.password= password;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }
}
