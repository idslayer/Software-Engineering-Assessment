package com.example.bemediasearch.dtos;

public class UserPrincipal {
    private String username;
    private String fullname;

    public UserPrincipal(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }


    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }
}
