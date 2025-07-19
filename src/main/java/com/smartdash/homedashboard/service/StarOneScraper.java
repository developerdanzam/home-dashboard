package com.smartdash.homedashboard.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class StarOneScraper
{
    public String scrapeData() throws Exception {
        Document doc = Jsoup.connect("https://www.starone.org/mortgage-rates-today")
                .userAgent("Mozilla/5.0").timeout(10_000).get();

        // Extract whatever you need; example:
        Element rate = doc.selectFirst(".rate-apr-flex .apr-val");

        return rate != null ? rate.text() : "No rate found";
    }
}
