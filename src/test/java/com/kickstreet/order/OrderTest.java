package com.kickstreet.order;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

public class OrderTest {

    @Nested
    class ConstructorTest {

        @Test
        void testValidOrderInit() {
            String customerId = UUID.randomUUID().toString();
            String productName = "Air Jordan 1 Retro High";
            double price = 180.00;

            Order order = new Order(customerId, productName, price);

            assertNotNull(order);
            assertEquals(order.getCustomerId(), customerId);
            assertEquals(order.getProductName(), productName);
            assertEquals(order.getPrice(), price);
        }

        @Test
        void testInvalidOrderInit() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Order(null, "Air Jordan 1 Retro High", 100);
            });

            assertThrows(IllegalArgumentException.class, () -> {
                new Order(UUID.randomUUID().toString(), null, 100);
            });

            assertThrows(IllegalArgumentException.class, () -> {
                new Order(UUID.randomUUID().toString(), "Air Jordan 1 Retro High", -20);
            });
        }
    }
}
