package com.example.demo.automatons;

import com.example.demo.entities.investment.Security;
import com.example.demo.repositories.SecurityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecuritiesUpdater implements Runnable {


    private static final String WORLDSTOCK_API_KEY = System.getenv("WORLDSTOCK_API_KEY");

    @Override
    public void run() {

    }

    public static Security updateStockData(Security security, SecurityRepository securityRepository) {
        String symbol = security.getSymbol();

        try {
            RestTemplateBuilder builder = new RestTemplateBuilder();
            RestTemplate restTemplate = builder.build();

            String uriString = String.format("https://api.worldtradingdata.com/api/v1/stock?symbol=%s&api_token=%s",symbol,WORLDSTOCK_API_KEY);
            String jsonObject = restTemplate.getForObject(uriString, String.class);
            JSONObject jsonObj = new JSONObject(jsonObject);

            jsonObj = jsonObj.getJSONArray("data").getJSONObject(0);

            security.setCurrentPrice(jsonObj.getDouble("price"));
            security.setDayChange(jsonObj.getDouble("day_change"));
            security.setDayChangePct(jsonObj.getDouble("change_pct"));
            System.out.println(security);
            securityRepository.save(security);
            return security;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Security getHistoricalData(Security security, SecurityRepository securityRepository) {
        String symbol = security.getSymbol();
        HashMap<LocalDate,Double> stockHistory = security.getPrices();
        if (stockHistory == null) {
            stockHistory = new HashMap<LocalDate,Double>();
        } else if (stockHistory.containsKey(getLastWeekday())) {
            //System.out.println("All caught up");
            return security;
        }

        try {
            RestTemplateBuilder builder = new RestTemplateBuilder();
            RestTemplate restTemplate = builder.build();

            String uriString = String.format("https://api.worldtradingdata.com/api/v1/history?symbol=%s&sort=newest&api_token=%s",symbol,WORLDSTOCK_API_KEY);
            String jsonObject = restTemplate.getForObject(uriString, String.class);
            JSONObject jsonObj = new JSONObject(jsonObject);

            JSONObject history = jsonObj.getJSONObject("history");

            Iterator keys = history.keys();
            while(keys.hasNext()) {
                String dateString = (String) keys.next();
                LocalDate date = LocalDate.parse(dateString);

                double price = history.getJSONObject(dateString).getDouble("close");
                if (date.isAfter(LocalDate.parse("2017-01-01")) && !stockHistory.containsKey(date)) {
                    System.out.println("Adding");
                    System.out.println(date);
                    System.out.println(price);
                    stockHistory.put(date,price);
                }

            }

            security.setPrices(stockHistory);
            securityRepository.save(security);
            return security;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static LocalDate getLastWeekday() {
        LocalDate mostRecentWeekday = LocalDate.now();
        while (mostRecentWeekday.getDayOfWeek() == DayOfWeek.SATURDAY || mostRecentWeekday.getDayOfWeek() == DayOfWeek.SUNDAY) {
            mostRecentWeekday = mostRecentWeekday.minusDays(1);
        }
        return mostRecentWeekday;
    }

}
