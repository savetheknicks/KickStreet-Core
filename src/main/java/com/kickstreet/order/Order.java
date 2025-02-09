package com.kickstreet.order;

public class Order {

    private String orderId;
    private String customerId;
    private String productName;
    private double price;

    public Order(String orderId, String customerId, String productName, double price) {
        this.orderId = orderId;
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
