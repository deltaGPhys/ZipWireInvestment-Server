package com.example.demo.automatons;

import com.example.demo.Configuration;
import com.example.demo.entities.investment.Security;
import com.example.demo.repositories.SecurityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecuritiesUpdater implements Runnable {


    private static final String WORLDSTOCK_API_KEY = System.getenv("WORLDSTOCK_API_KEY");

    @Override
    public void run() {

    }

    public static Security getNewPrice(Security security, SecurityRepository securityRepository) {
        String symbol = security.getSymbol();

        try {
            RestTemplateBuilder builder = new RestTemplateBuilder();
            RestTemplate restTemplate = builder.build();
            ObjectMapper mapper = new ObjectMapper();

            String uriString = String.format("https://api.worldtradingdata.com/api/v1/stock?symbol=%s&api_token=%s",symbol,WORLDSTOCK_API_KEY);
            //System.out.println(uriString);
            LinkedHashMap<String,Object> jsonObject = (LinkedHashMap<String, Object>) restTemplate.getForObject(uriString, Object.class);
            String output = jsonObject.toString();

            System.out.println(jsonObject.toString());
            System.out.println(jsonObject.get("data"));
            Matcher matcher = Pattern.compile("(?<=\\bprice=)([\\d\\.\\d]*)").matcher(jsonObject.get("data").toString());

            String match = "";
            while (matcher.find()) {
                match = matcher.group(0);
            }
            System.out.println(match);
            if (isNumeric(match)) {
                security.setShareCost(Double.parseDouble(match));
                securityRepository.save(security);
            }
            return security;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public Datum parseData (LinkedHashMap<String,Object> jsonObject) {
        HashMap<String,Object> result = new HashMap<String,Object>();
        try {
            long timestamp = new Long((Integer) jsonObject.get("timestamp"));
            LinkedHashMap<String, Object> ticker = (LinkedHashMap<String, Object>) jsonObject.get("ticker");
            String currency = (String) ticker.get("base");
            Double price = Double.parseDouble((String) ticker.get("price"));
            Double volume = Double.parseDouble((String) ticker.get("volume"));
            Double change = Double.parseDouble((String) ticker.get("change"));

            return new Datum(currency, price, volume, change, timestamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
