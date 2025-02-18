package com.kickstreet.store;

import java.util.HashMap;

import com.kickstreet.customer.Customer;
import com.kickstreet.order.Order;
import com.kickstreet.product.Product;

public class Store {

    private HashMap<String, Product> products = new HashMap<>();

    public HashMap<String, Product> getProducts() {

        return products;
    }

    public void addProduct(Product product) {

        if (products.containsKey(product.getProductId())) {
            throw new IllegalArgumentException("Product Already exists!");
        }

        this.products.put(product.getProductId(), product);
    }

    public Boolean isProductInStock(String productId) {

        Product product = products.get(productId);
        return product.getStock() > 0;
    }

    public Order processOrder(Customer customer, String productId, int quantity) {

        if (!products.containsKey(productId)) {
            throw new IllegalArgumentException("Product with ID " + productId + " does not exist.");
        }

        if (!isProductInStock(productId)) {
            throw new IllegalStateException("Not enough stock available for product: " + productId);
        }

        String customerId = customer.getCustomerId();
        Product product = products.get(productId);
        String productName = product.getName();
        double orderCost = product.getPrice() * quantity;

        product.updateStock(-quantity);

        Order processedOrder = new Order(customerId, productName, orderCost);

        return processedOrder;

    }

}
