package com.kickstreet.order;

import java.util.UUID;

public class Order {

    private String orderId;
    private String customerId;
    private String productName;
    private double price;

    public Order(String customerId, String productName, double price) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }

        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product Name cannot be null or empty");
        }

        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be a negative.");
        }

        this.orderId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.productName = productName;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

}
