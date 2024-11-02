package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

import com.example.demo.Models.Product;
import com.example.demo.Repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner {
    
    @Autowired
    private ProductRepository productRepository;
    

    public void run(String...args) throws Exception {
        if (productRepository.count() == 0) {
            List<Product> products = Arrays.asList(
                new Product(null, "APPLE", 245.67, "super device", 5.0, "electronics", "gomo", 198, 9,Arrays.asList("https://picsum.photos/v2/list"))
            );
            
            // Save the products to the database
            productRepository.saveAll(products);
            
            System.out.println("Data seeding completed successfully!");
        }
    }
}