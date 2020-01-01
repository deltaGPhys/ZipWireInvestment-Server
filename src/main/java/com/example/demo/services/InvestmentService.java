package com.example.demo.services;

import com.example.demo.dto.SecurityHistoryDTO;
import com.example.demo.entities.Investment;
import com.example.demo.entities.investment.Security;
import com.example.demo.entities.investment.SecurityHolding;
import com.example.demo.repositories.InvestmentRepository;
import com.example.demo.repositories.SecurityHoldingRepository;
import com.example.demo.repositories.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Autowired
    private SecurityRepository securityRepository;

    @Autowired
    private SecurityHoldingRepository securityHoldingRepository;

    @Autowired
    private AuthenticationService authenticationService;

    public Investment findById(Long id){
        return investmentRepository.findById(id).get();
    }

    public Investment getForUser(Long id) {
        return investmentRepository.findFirstByOwner(authenticationService.showUser(id));
    }

    public Investment createAccount(Investment investment) {
        return investmentRepository.save(investment);
    }

    public Security getSecurity(Long id) {
        return securityRepository.findById(id).get();
    }

    public SecurityHolding getSecurityHolding(Long id) {
        return securityHoldingRepository.findById(id).get();
    }

    public Iterable<SecurityHolding> getSecurityHoldingsByAccount(Long id) {
        return securityHoldingRepository.findAllByAccountId(id);
    }


    public SecurityHolding buyNewSecurity(int accountId, int securityId, double numShares) {
        Investment account = investmentRepository.findById((long) accountId).get();
        Security security = securityRepository.findById((long) securityId).get();
        SecurityHolding newHolding = new SecurityHolding(account, security, numShares, 0.0, security.getCurrentPrice(), LocalDate.now());
        return securityHoldingRepository.save(newHolding);
    }

    public void sellHolding(long holdingId) {
        securityHoldingRepository.deleteById(holdingId);
    }

    public boolean verifyHolding(long holdingId) {
        return securityHoldingRepository.existsById(holdingId);
    }

    public SecurityHistoryDTO getSecurityHistory(long id, LocalDate startDate) {
        Security security = securityRepository.findById(id).get();
        return (security != null) ? new SecurityHistoryDTO(security, startDate): null;
    }

    public SecurityHistoryDTO getSecurityHistory(long id) {
        Security security = securityRepository.findById(id).get();
        return (security != null) ? new SecurityHistoryDTO(security): null;
    }
}
