package com.example.demo.automatons;

import com.example.demo.entities.investment.Security;
import com.example.demo.repositories.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Configuration
public class StockConfig {

    @Autowired
    SecurityRepository securityRepository;

    @Bean
    @PostConstruct
    public void defineStocks() {
        Security[] securities = new Security[]{
            new Security(1, "AAPL", "Apple"),
            new Security(2, "ATVI", "Activision Blizzard"),
            new Security(3, "AMZN", "Amazon"),
            new Security(4, "CSCO", "Cisco Systems"),
            new Security(5, "EA", "Electronic Arts"),
            new Security(6, "EBAY", "eBay"),
            new Security(7, "FB", "Facebook"),
            new Security(8, "GOOGL", "Alphabet Class A"),
            new Security(9, "INTC", "Intel"),
            new Security(10, "MCHP", "Microchip Technology"),
            new Security(11, "MSFT", "Microsoft"),
            new Security(12, "NTAP", "NetApp"),
            new Security(13, "NFLX", "Netflix"),
            new Security(14, "PYPL", "Paypal"),
            new Security(15, "QCOM", "Qualcomm"),
            new Security(16, "NLOK", "Norton LifeLock"),
            new Security(17, "TSLA", "Tesla"),
            new Security(18, "VRSN", "Verisign"),
            new Security(19, "WDC", "Western Digital"),
            new Security(20, "XLNX", "Xilinx")
        };

//        for (Security s: securities) {
//            if (securityRepository.findByIdAndSymbolAndName(s.getId(), s.getSymbol(), s.getName()) == null) {
//                securityRepository.save(s);
//            }
//        }

    }

    @Bean
    @PostConstruct
    public void updateStockData() {
        Iterable<Security> securities = securityRepository.findAll();

        for (Security s: securities) {
            SecuritiesUpdater.getHistoricalData(s, securityRepository);
        }

        DayOfWeek today = LocalDate.now().getDayOfWeek();
        securities = securityRepository.findAll();
        for (Security s: securities) {
            if (s.getCurrentPrice() == 0. || !(today == DayOfWeek.SATURDAY || LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY)) {
                System.out.println("getting data for today");
                //SecuritiesUpdater.updateStockData(s, securityRepository);
            }
        }
    }
}
