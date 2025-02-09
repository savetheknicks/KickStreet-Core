package com.kickstreet.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Product Test")
public class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("AJR3-002", "Air Jordan 3 Retro SE", 200.00, 40);
    };

    @Test
    void testValidProductInit() {
        String productId = "AJR1-001";
        String name = "Air Jordan 1 Retro High";
        double price = 180.00;
        int stock = 50;

        Product product = new Product(productId, name, price, stock);

        assertNotNull(product);
        assertEquals(product.getProductId(), productId);
        assertEquals(product.getName(), name);
        assertEquals(product.getPrice(), price);
        assertEquals(product.getStock(), stock);

    }
}
