package com.kickstreet.customer;

import java.util.UUID;

public class Customer {

    private static final CustomerValidator validator = new CustomerValidator();
    private String name;
    private String email;
    private String customerId;

    public Customer(String name, String email) {

        validator.validate(name, email);

        this.name = name;
        this.email = email;
        this.customerId = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void updateProfile(String customerName, String customerEmail) {

        if (customerName != null) {
            validator.validateName(customerName);
            this.name = customerName;
        }

        if (customerEmail != null) {
            validator.validateEmail(customerEmail);
            this.email = customerEmail;
        }
    }
}
