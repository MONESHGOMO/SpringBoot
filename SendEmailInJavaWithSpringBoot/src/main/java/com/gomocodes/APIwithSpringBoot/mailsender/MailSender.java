package com.gomocodes.APIwithSpringBoot.mailsender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component("CustomMailSender")
public class MailSender {

    private final JavaMailSender mailSender;

    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    @Autowired
    public MailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    private final SimpleMailMessage message = new SimpleMailMessage();

    public void sendEmailForGetAllData(String from, String to, String subject, String text) {
        try {
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            mailSender.send(message);
            logger.info("Email sent successfully!");
        } catch (Exception e) {
            logger.error("Error sending email: {}", e.getMessage(), e);
        }
    }

    public void sendEmailForGetDataByUsingID(String from, String to, String subject, String text) {
        try {
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            mailSender.send(message);
            logger.info("Email sent!");
        } catch (Exception e) {
            logger.error("Error sending email: {}", e.getMessage(), e);
        }
    }

    public void sendEmailForPostMethodAccepted(String from, String to, String subject, String text) {
        try {
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            mailSender.send(message);
            logger.info("Email sent for post method accepted!");
        } catch (Exception e) {
            logger.error("Error sending email: {}", e.getMessage(), e);
        }
    }

    public void sendEmailForDataDeletedById(String from, String to, String subject, String text) {
        try {
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            mailSender.send(message);
            logger.info("Email sent for data deleted by id!");
        } catch (Exception e) {
            logger.error("Error sending email: {}", e.getMessage(), e);
        }
    }

    public void sendEmailForDataUpdatedById(String from, String to, String subject, String text) {
        try {
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            mailSender.send(message);
            logger.info("Email sent for data updated by id!");
        } catch (Exception e) {
            logger.error("Error sending email: {}", e.getMessage(), e);
        }
    }
}