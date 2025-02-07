package com.kickstreet;

import java.util.UUID;

public class Customer {
    
    private String name;
    private String email;
    private String CustomerId;

    public Customer(String name, String email) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        this.name = name;
        this.email = email;
        this.CustomerId = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
