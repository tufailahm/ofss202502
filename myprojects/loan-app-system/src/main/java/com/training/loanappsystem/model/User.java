package com.training.loanappsystem.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users_ofss")
public class User {

    @Id
    @Column(unique = true)
    private String username;

    private String password;

    public User( String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {}


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