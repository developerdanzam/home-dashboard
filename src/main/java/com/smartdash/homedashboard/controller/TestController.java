package com.smartdash.homedashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // This is a test controller to verify the application is running
    @GetMapping("/test")
    public String testEndpoint() {
        return "Test endpoint is working!";
    }
}
