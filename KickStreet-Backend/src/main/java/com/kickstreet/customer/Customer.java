package com.kickstreet.customer;

import java.util.UUID;

public class Customer {
    
    private static final CustomerValidator validator = new CustomerValidator();
    private String name;
    private String email;
    private String CustomerId;

    public Customer(String name, String email) {

        validator.validate(name, email);

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

    public void updateProfile(String customerName, String customerEmail) {

        validator.validate(customerName, customerEmail);

        this.name = customerName;
        this.email = customerEmail;
    }
}

