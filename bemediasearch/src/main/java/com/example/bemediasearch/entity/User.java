package com.example.bemediasearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class User {
    private String username;
    private String fullName;
    private String passwordHash;

    public String getUsername() {
        return username;
    }
    public String getFullname(){
        return fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public User(String username, String fullName, String passwordHash) {
        this.username = username;
        this.fullName = fullName;
        this.passwordHash = passwordHash;
    }
}
