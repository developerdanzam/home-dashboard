package com.smartdash.homedashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeDashboardApplication {
	private static final Logger logger = LoggerFactory.getLogger(HomeDashboardApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(HomeDashboardApplication.class, args);
		logger.info("Home Dashboard Application started successfully.");
	}

}
