package com.smartdash.homedashboard.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.smartdash.homedashboard.service.EmailService;
import com.smartdash.homedashboard.service.StarOneScraper;

@Component
public class DailyEmailJob
{
    private static final Logger logger = LoggerFactory.getLogger(DailyEmailJob.class);

    @Autowired
    private StarOneScraper scraper; // Your service to get content

    @Autowired
    private EmailService emailService; // Your existing email sender service
    @Value("${GMAIL_RECIPIENT}")
    private String gmail;

    // Run every day at 12:00 PM local time
    @Scheduled(cron = "0 0 12 * * *", zone = "America/Los_Angeles")
    public void sendDailyEmail() {
        // Get content from scraper
        try
        {
            String content = scraper.scrapeData();
            double percentage = Double.parseDouble(content.replace("%", "").trim());

            if (percentage <= 6.0)
            {
                emailService.sendSimpleEmail(gmail, "Daily Update", content);
                logger.info("Daily email sent with content: {}", content);
            } else
            {
                logger.info("Percentage is above threshold, no email sent. Current percentage: {}",
                        percentage);
            }
        } catch (Exception e)
        {
            logger.error("Failed to process and send daily email", e);
        }
    }

}
