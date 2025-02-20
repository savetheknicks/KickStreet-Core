package com.kickstreet;

import com.kickstreet.store.Store;
import com.kickstreet.product.Product;
import com.kickstreet.customer.Customer;
import com.kickstreet.order.Order;

public class Main {
    public static void main(String[] args) {
        // 1️ Create the Store
        Store kickStreet = new Store();

        // 2️ Add Products to the Store
        Product jordan1 = new Product("AJR1-001", "Air Jordan 1 Retro High", 180.00, 10);
        Product jordan3 = new Product("AJR3-002", "Air Jordan 3 Retro SE", 200.00, 5);

        kickStreet.addProduct(jordan1);
        kickStreet.addProduct(jordan3);

        // 3️ Create a Customer
        Customer customer = new Customer("John Doe", "johndoe@email.com");

        // 4️ Check if Product is in Stock before Ordering
        String productId = "AJR1-001";
        int orderQuantity = 2;

        if (kickStreet.isProductInStock(productId)) {
            try {
                // 5️ Process an Order if the Product is Available
                Order order = kickStreet.processOrder(customer, productId, orderQuantity);

                // 6️ Print Order Details
                System.out.println("\nOrder placed successfully!");
                System.out.println("Order ID: " + order.getOrderId());
                System.out.println("Customer ID: " + order.getCustomerId());
                System.out.println("Product: " + order.getProductName());
                System.out.println("Total Price: $" + order.getPrice());

                // 7️ Check Stock After Order
                System.out.println("\nRemaining stock of " + productId + ": " + jordan1.getStock());

            } catch (Exception e) {
                System.out.println("Order Failed: " + e.getMessage());
            }
        } else {
            System.out.println("Product " + productId + " is out of stock!");
        }

        // 8 Attempt to Order More Than Available Stock
        try {
            Order failedOrder = kickStreet.processOrder(customer, productId, 20); // Too many
            System.out.println("\nUnexpected success, order ID: " + failedOrder.getOrderId());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
