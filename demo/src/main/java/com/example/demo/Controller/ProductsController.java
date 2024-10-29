package com.example.demo.Controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Product;
import com.example.demo.Services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductsController {

     @Autowired
    private ProductService productservise;
    
    @GetMapping
    public List<Product> getAllProducts(){
        return productservise.getAllProducts();
            

    }

    @GetMapping("/category")
    public List<Map<String,Object>> category(){
        return Arrays.asList(
            Map.of("name ","product 1","price",343),
            Map.of("name ","product 2","price",623),
            Map.of("name ","product 3","price",223)
        );

    }
}
