package com.gomocodes.SendEmailUsingJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/send-email")
    public String sendEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("moneshprogrammer@gmail.com");
            message.setTo("moneshprogrammer@gmail.com");
            message.setSubject("Java Email Sender");
            message.setText("Gomo, you are now in Java email sender");

            mailSender.send(message);
            return "Email sent successfully!";
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }
    }
}