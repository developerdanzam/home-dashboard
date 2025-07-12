package com.smartdash.homedashboard.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    // This is a test controller to verify the application is running
@GetMapping("/time")
public ResponseEntity<Date> testEndpoint() {
    return ResponseEntity.ok(new Date());  // 200 OK with body
}
}
