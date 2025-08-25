package com.testing.SpringBoot.Testing.serviceForTesting;

import org.springframework.stereotype.Service;
import java.time.Year;

@Service
public class DiscountService {

    public float calculateDiscount(String promoCode , float amount) {
        if (promoCode == null) {
            return amount; // no discount
        }

        // Flat discount of 10%
        if (promoCode.equals("UJIFHUIQERHFF")) {
            return amount - (amount * 0.10f);
        }

        // 25% discount only for year 2025
        if (promoCode.equals("bhuhrhuqer") && getCurrentYear().getValue() == 2025) {
            return amount - (amount * 0.25f);
        }

        return amount;
    }

    private Year getCurrentYear() {
        return Year.now();
    }
}
