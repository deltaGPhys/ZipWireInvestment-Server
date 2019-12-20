package com.example.demo.automatons;

import com.example.demo.entities.investment.Security;
import com.example.demo.repositories.SecurityRepository;

public class SecuritiesUpdater implements Runnable {

    private SecurityRepository securityRepository;

    public SecuritiesUpdater(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    @Override
    public void run() {

    }

    public Security getNewPrice(Security security) {
        return null;
    }
}
