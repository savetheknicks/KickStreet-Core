package com.kickstreet.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kickstreet.product.Product;

public class Store {

    private HashMap<String, Product> products = new HashMap<>();

    public List<Product> getProducts() {

        List<Product> all_products = new ArrayList<>(products.values());

        return all_products;
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
}
