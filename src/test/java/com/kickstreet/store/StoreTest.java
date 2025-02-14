package com.kickstreet.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.kickstreet.product.Product;

public class StoreTest {

    private Store store;

    @Nested
    class ConstructorTest {

        @Test
        void testStoreValidInit() {
            Store store = new Store();
            List<Product> products = store.getProducts();

            assertNotNull(products);
            assertTrue(products.isEmpty());
        }
    }

    @Nested
    class addProductTest {

        @BeforeEach
        void setUp() {
            store = new Store();
        }

        @Test
        void testAddingValidProduct() {
            Product product = new Product("AJR1-001", "Air Jordan 1 Retro High", 180.00, 50);
            store.addProduct(product);

            List<Product> products = store.getProducts();

            assertFalse(products.isEmpty());
            assertEquals(products.size(), 1);

        }

        @Test
        void testAddingMultipleProducts() {
            Product product1 = new Product("AJR1-001", "Air Jordan 1 Retro High", 180.00, 50);
            Product product2 = new Product("AJR3-002", "Air Jordan 3 Retro SE", 200.00, 40);
            Product product3 = new Product("AJR4-003", "Air Jordan 4 Retro OG", 220.00, 30);
            Product product4 = new Product("AJR5-004", "Air Jordan 5 Retro Low", 190.00, 20);
            Product product5 = new Product("AJR6-005", "Air Jordan 6 Retro PSG", 225.00, 25);

            store.addProduct(product1);
            store.addProduct(product2);
            store.addProduct(product3);
            store.addProduct(product4);
            store.addProduct(product5);

            List<Product> products = store.getProducts();

            assertEquals(products.size(), 5);
        }

        @Test
        void testAddingDuplicateProductsAreNotAllowed() {

            Product product1 = new Product("AJR1-001", "Air Jordan 1 Retro High", 180.00, 50);
            Product product2 = new Product("AJR1-001", "Air Jordan 1 Retro High", 180.00, 50);

            store.addProduct(product1);

            assertThrows(IllegalArgumentException.class, () -> {
                store.addProduct(product2);
            });

        }

        @Nested
        class isProductInStockTest {

            @BeforeEach
            void setUp() {
                store = new Store();

            }

            @Test
            void testIsProductInStockWithStockedProduct() {

                Product productWithStock = new Product("AJR1-001", "Air Jordan 1 Retro High", 180.00, 50);
                String productWithStockId = productWithStock.getProductId();

                store.addProduct(productWithStock);

                assertTrue(store.isProductInStock(productWithStockId));
            }

            @Test
            void testIsProductInStockWithOutStockedProduct() {

                Product productWithoutStock = new Product("AJR3-002", "Air Jordan 3 Retro SE", 200.00, 0);
                String productWithoutStockId = productWithoutStock.getProductId();

                store.addProduct(productWithoutStock);

                assertFalse(store.isProductInStock(productWithoutStockId));
            }
        }

    }
}
