package com.smartdash.homedashboard.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartdash.homedashboard.service.StarOneScraper;

@RestController
@RequestMapping("/test")
public class TestController {
    private final StarOneScraper startOneScraper;

    public TestController(StarOneScraper starOneScraper) {
        this.startOneScraper = starOneScraper;
    }

    // This is a test controller to verify the application is running
    @GetMapping("/time")
    public ResponseEntity<Date> testEndpoint() {
        return ResponseEntity.ok(new Date()); // 200 OK with body
    }

    @GetMapping("/startone-rates")
    public ResponseEntity<String> starOneRates() throws Exception {
        return ResponseEntity.ok(startOneScraper.scrapeData());
    }
}
