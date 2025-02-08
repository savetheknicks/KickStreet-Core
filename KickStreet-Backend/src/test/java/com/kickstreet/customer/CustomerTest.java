package com.kickstreet.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Customer Test")
public class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Emilio Perez", "emilioperez@gmail.com");
    };

    @Test
    void testCustomerInit() {
        Customer customer = new Customer("John Doe", "johndoe@yahoo.com");
        assertNotNull(customer);
    };

    @Test
    void testCustomerInitThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Customer customer = new Customer(null, " ");
        });
    };

    @Test
    void testCustomerGetName() {
        String customerName = customer.getName();
        String expectedName = new String("Emilio Perez");
        assertEquals(expectedName, customerName);
    }

    @Test
    void testCustomerGeEmail() {
        String customerEmail = customer.getEmail();
        String expectedEmail = new String("emilioperez@gmail.com");
        assertEquals(expectedEmail, customerEmail);
    }

    @Test
    void testCustomerUpdateProfile() {
        String currentEmail = customer.getEmail();
        String currentCustomerName = customer.getName();

        assertEquals(customer.getName(), currentCustomerName);
        assertEquals(customer.getEmail(), currentEmail);

        String newEmail = "wakalitohernandez@gmail.com";
        String newCustomerName = "Wakalito Hernandez";

        customer.updateProfile(newCustomerName, newEmail);

        assertEquals(customer.getName(), newCustomerName);
        assertEquals(customer.getEmail(), newEmail);

    }

    @Test
    void testCustomerUpdateProfileThrowsDataValidationError() {

    }

}
