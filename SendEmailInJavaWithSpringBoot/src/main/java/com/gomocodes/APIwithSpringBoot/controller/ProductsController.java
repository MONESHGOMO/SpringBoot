package com.gomocodes.APIwithSpringBoot.controller;

import java.util.List;

import com.gomocodes.APIwithSpringBoot.mailsender.MailSender;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gomocodes.APIwithSpringBoot.model.Electronics;
import com.gomocodes.APIwithSpringBoot.serviceLayer.ProductService;

@RestController
public class ProductsController {

    @Autowired
    private ProductService productService;
    @Autowired
    private final MailSender mailSender;

    public ProductsController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    Logger logger = LoggerFactory.getLogger(ProductsController.class);


    @GetMapping("/getProducts")
    public ResponseEntity<List<Electronics>> getAllProducts() {
        try {
            logger.info("All products are fetched from DB");
            mailSender.sendEmailForGetAllData("moneshprogrammer@gmail.com","dmonesh198@gmail.com","Including JavaEmail Sender ","All Data Are Fetched From MySQL, for more stay connect my loving and respected connections.....");
            return productService.getAllProducts();
        } catch (Exception e) {
            logger.error("Error fetching products from DB", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProducts/{id}")
    public ResponseEntity<Electronics> getElectricalProductByID(@PathVariable Long id) {
        try {
            logger.info("Products are fetched from DB based on the ID {}", id);
            mailSender.sendEmailForGetDataByUsingID("moneshprogrammer@gmail.com","dmonesh198@gmail.com","Including JavaEmail Sender "," Data Are Fetched From MySQL using ID , for more stay connect my loving and respected connections.....");
            return productService.getElectricalProductByID(id);
        } catch (Exception e) {
            logger.warn("Product with ID {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addProducts")
    public ResponseEntity<Electronics> createElectronics(@RequestBody Electronics addElectronics) {
        try {
            logger.info("Products are inserted into DB: {}", addElectronics);
            mailSender.sendEmailForPostMethodAccepted("moneshprogrammer@gmail.com","dmonesh198@gmail.com","Including JavaEmail Sender "," Data Are Fetched to  MySQL, for more stay connect my loving and respected connections.....");
            return productService.insertElectronics(addElectronics);
        } catch (Exception exception) {
            logger.error("Error creating product: {}", addElectronics, exception);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/getProducts/{id}")
    public ResponseEntity<Electronics> updateElectronics(@PathVariable Long id, @RequestBody Electronics update) {
        try {
            logger.info("Products are updated in DB: {}", id);
            Electronics updatedProduct = productService.getElectricalProductByID(id).getBody();

            if(updatedProduct !=null){
                updatedProduct.setProductName(update.getProductName());
                updatedProduct.setBrand(update.getBrand());
                updatedProduct.setCategory(update.getCategory());
                updatedProduct.setDescription(update.getDescription());
                updatedProduct.setPrice(update.getPrice());
                updatedProduct.setImageUrl(update.getImageUrl());
                updatedProduct.setQuantityInStock(update.getQuantityInStock());

                productService.insertElectronics(updatedProduct);
                mailSender.sendEmailForDataUpdatedById("moneshprogrammer@gmail.com","dmonesh198@gmail.com"," JavaEmail Sender "," Data updated using ID and stored in  to  MySQL, for more stay connect my loving and respected connections.....");
                return new ResponseEntity<>(HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        }
        catch (Exception e) {
            logger.error("Error updating product with ID {}", id, e);
            mailSender.sendEmailForDataUpdatedById("moneshprogrammer@gmail.com","dmonesh198@gmail.com"," JavaEmail Sender "," Something went wrong check the log message .....");

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteProducts/{id}")
    public ResponseEntity<String> deleteElectricalProductByID(@PathVariable Long id) {
        try {
            productService.deleteElectricalProductByID(id);
            logger.info("Deleted Product ID: {}", id);
            mailSender.sendEmailForDataDeletedById("moneshprogrammer@gmail.com","dmonesh198@gmail.com"," JavaEmail Sender "," Data deleted using ID from the   MySQL, for more stay connect my loving and respected connections.....");

            return new ResponseEntity<>("Product deleted successfully", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Error deleting product with ID {}", id, e);
            mailSender.sendEmailForDataDeletedById("moneshprogrammer@gmail.com","dmonesh198@gmail.com"," JavaEmail Sender "," Something went wrong check the log message .....");

            return new ResponseEntity<>("Error deleting product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
