package com.kickstreet.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Product Test")
public class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(null, null, 0, 0);
    };
}
