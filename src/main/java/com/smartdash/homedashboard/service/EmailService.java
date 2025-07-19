package com.smartdash.homedashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${GMAIL_EMAIL}")
    private String gmail;
    
    public void sendSimpleEmail(String to, String subject, String message) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject); // optional for SMS
        email.setText(message);
        email.setFrom(gmail); // must match spring.mail.username
        mailSender.send(email);
        System.out.println("✅ Message sent to " + to);
    }
}