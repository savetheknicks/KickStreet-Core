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

    @Test
    void shouldThrowExceptionWhenProductIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product(null, "Air Jordan 1 Retro High", 180.00, 50);
        });
    }

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("AJR1-001", " ", 180.00, 50);
        });
    }

    @Test
    void shouldThrowExceptionWhenPriceIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("AJR1-001", "Air Jordan 1 Retro High", -180.00, 50);
        });
    }

    @Test
    void shouldThrowExceptionWhenStockIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("AJR1-001", "Air Jordan 1 Retro High", 180.00, -50);
        });
    }

    @Test
    void testUpdateStockWithPositiveQuantity() {
        int current_stock = product.getStock();
        int increase_quantity = 100;
        int expected_new_quantity = current_stock + increase_quantity;

        product.updateStock(increase_quantity);

        assertNotEquals(product.getStock(), current_stock);
        assertEquals(product.getStock(), expected_new_quantity);
    }

    @Test
    void testUpdateStockWithNegativeQuantity() {
        int current_stock = product.getStock();
        int decrease_quantity = -20;
        int expected_new_quantity = current_stock - Math.abs(decrease_quantity);

        product.updateStock(decrease_quantity);

        assertNotEquals(product.getStock(), current_stock);
        assertEquals(product.getStock(), expected_new_quantity);
    }

    @Test
    void testUpdateWithBelowZeroNegativeQuantity() {
        product.setStock(0);
        assertThrows(IllegalArgumentException.class, () -> {
            product.updateStock(-20);
        });
    }

    @Test
    void testUpdateWithZeroQuantity() {
        String result = product.updateStock(0);
        assertEquals("Please provide a non zero quantity", result);
    }

}