package com.example.demo.automatons;

import com.example.demo.entities.investment.Security;
import com.example.demo.repositories.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.parameters.P;

import javax.annotation.PostConstruct;

@Configuration
public class StockConfig {

    @Autowired
    SecurityRepository securityRepository;

    @Bean
    @PostConstruct
    public void defineStocks() {
        securityRepository.save(new Security(1,"AAPL","Apple"));
        securityRepository.save(new Security(2,"ATVI","Activision Blizzard"));
        securityRepository.save(new Security(3,"AMZN", "Amazon"));
        securityRepository.save(new Security(4,"CSCO","Cisco Systems"));
        securityRepository.save(new Security(5,"EA","Electronic Arts"));
        securityRepository.save(new Security(6,"EBAY","eBay"));
        securityRepository.save(new Security(7,"FB","Facebook"));
        securityRepository.save(new Security(8,"GOOGL","Alphabet Class A"));
        securityRepository.save(new Security(9,"INTC","Intel"));
        securityRepository.save(new Security(10,"MCHP","Microchip Technology"));
        securityRepository.save(new Security(11,"MSFT","Microsoft"));
        securityRepository.save(new Security(12,"NTAP","NetApp"));
        securityRepository.save(new Security(13,"NFLX","Netflix"));
        securityRepository.save(new Security(14,"PYPL","Paypal"));
        securityRepository.save(new Security(15,"QCOM","Qualcomm"));
        securityRepository.save(new Security(16,"NLOK","Norton LifeLock"));
        securityRepository.save(new Security(17,"TSLA","Tesla"));
        securityRepository.save(new Security(18,"VRSN","Verisign"));
        securityRepository.save(new Security(19,"WDC","Western Digital"));
        securityRepository.save(new Security(20,"XLNX","Xilinx"));
    }

    @Bean
    @PostConstruct
    public void updateStockData() {
        Iterable<Security> securities = securityRepository.findAll();

        for (Security s: securities) {
            SecuritiesUpdater.getNewPrice(s, securityRepository);
            System.out.println(s);
        }
    }
}
