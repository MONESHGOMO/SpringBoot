package com.gomocodes.APIwithSpringBoot.serviceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gomocodes.APIwithSpringBoot.model.Electronics;
import com.gomocodes.APIwithSpringBoot.repositoryLayer.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<Electronics>> getAllProducts() {
        List<Electronics> electronicsList = productRepository.findAll();
        return new ResponseEntity<>(electronicsList, HttpStatus.OK);
    }

    public ResponseEntity<Electronics> getElectricalProductByID(Long id) {
        Optional<Electronics> electronicsOptional = productRepository.findById(id);
        if (electronicsOptional.isPresent()) {
            Electronics electronics = electronicsOptional.get();
            return new ResponseEntity<>(electronics, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Electronics> insertElectronics(Electronics addElectronics) {
        Electronics savedElectronics = productRepository.save(addElectronics);
        return new ResponseEntity<>(savedElectronics, HttpStatus.CREATED);
    }

    public ResponseEntity<Electronics> updateElectronics(Long id, Electronics update) {
        Optional<Electronics> electronicsOptional = productRepository.findById(id);
        if (electronicsOptional.isPresent()) {
            Electronics electronics = electronicsOptional.get();
            electronics.setBrand(update.getBrand());
            electronics.setCategory(update.getCategory());
            electronics.setDescription(update.getDescription());
            electronics.setImageUrl(update.getImageUrl());
            electronics.setProductId(update.getProductId());
            electronics.setProductName(update.getProductName());
            electronics.setQuantityInStock(update.getQuantityInStock());
            electronics.setPrice(update.getPrice());

            productRepository.save(electronics);
            return new ResponseEntity<>(electronics, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> deleteElectricalProductByID(Long id) {
        productRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}