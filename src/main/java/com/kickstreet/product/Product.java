package com.kickstreet.product;

public class Product {

    private String productId;
    private String name;
    private double price;
    private int stock;

    public Product(String productId, String name, double price, int stock) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("ProductId cannot be null or empty");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be a negative");
        }

        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be a negative");
        }

        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Can't set quantity below zero. Please check current stock!!");
        }

        this.stock = stock;
    }

    public String updateStock(int quantity) {
        if (quantity > 0) {
            increaseQuantity(quantity);
            return "Stock updated successfully!";
        } else if (quantity < 0) {
            decreaseQuantity(quantity);
            return "Stock updated successfully!";
        } else {
            return "Please provide a non zero quantity";
        }
    }

    private void increaseQuantity(int quantity) {
        this.stock += quantity;
    }

    private void decreaseQuantity(int quantity) {

        int absQuantity = Math.abs(quantity);

        if (this.stock - absQuantity < 0) {
            throw new IllegalArgumentException("Can't set quantity below zero. Please check current stock!!");
        }
        this.stock -= absQuantity;
    }

}
