package com.testing.SpringBoot.Testing.serviceForTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// // https://www.youtube.com/watch?v=id_esCeLZBo
@SpringBootTest
public class StringProcessingServiceTest {

        @Autowired
        private StringProcessingService stringProcessingService;

        @Test
        public void testIsPalindromeWithValidPalindrome(){
           var result =  stringProcessingService.isPalindrome("gomo");
            Assertions.assertFalse(result);
        }

        @Test
        public void testIsPalindromeWithNullInput(){
            Assertions.assertThrows(NullPointerException.class,()->{
                stringProcessingService.isPalindrome(null);
            });
        }

        /*
    👉 What it does:
        Calls the method with null.
        Expects a NullPointerException.
        If the exception is thrown → test passes ✅.
        If no exception (or a different exception) is thrown → test fails ❌.
     */
}