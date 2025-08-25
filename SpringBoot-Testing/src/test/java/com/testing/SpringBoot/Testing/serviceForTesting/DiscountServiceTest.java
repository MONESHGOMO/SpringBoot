package com.testing.SpringBoot.Testing.serviceForTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DiscountServiceTest {


    @Autowired
    private  DiscountService discountService;

    @Test
    public void testNoDiscount() {
        float discount = discountService.calculateDiscount(null, 100f);
        Assertions.assertEquals(100f, discount);
    }
    @Test
    public void testTenPercentDiscount() {
        float discount = discountService.calculateDiscount("UJIFHUIQERHFF", 100f);
        Assertions.assertEquals(90f, discount); // 10% off
    }

    @Test
    public void testTwentyFivePercentDiscountFor2025() {
        float discount = discountService.calculateDiscount("bhuhrhuqer", 100f);
        if (Year.now().getValue() == 2025) {
            Assertions.assertEquals(75f, discount);
        } else {
            Assertions.assertEquals(100f, discount);
        }

        // 27:00

    }
}
