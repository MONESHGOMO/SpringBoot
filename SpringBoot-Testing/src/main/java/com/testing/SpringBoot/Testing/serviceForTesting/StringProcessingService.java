package com.testing.SpringBoot.Testing.serviceForTesting;

import org.springframework.stereotype.Service;

@Service
public class StringProcessingService {

    // check the given string is palindrome

    public boolean isPalindrome(String input){
        if(input==null){
            return false;
        }
        String reversed = new StringBuilder(input).reverse().toString();
        return reversed.equals(input);
    }


}
