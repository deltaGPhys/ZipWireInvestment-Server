package com.example.demo.services;

import com.example.demo.dto.SecurityHistoryDTO;
import com.example.demo.entities.Investment;
import com.example.demo.entities.Transaction;
import com.example.demo.entities.investment.Security;
import com.example.demo.entities.investment.SecurityHolding;
import com.example.demo.enums.TransactionType;
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

    @Autowired
    private TransactionService transactionService;

    public Investment findById(Long id){

        return investmentRepository.findById(id).get();
    }

    public Investment getForUser(Long id) {
        return investmentRepository.findFirstByOwner(authenticationService.showUser(id));
    }

    public Investment createAccount(Investment investment) {
        Investment newAcct = investmentRepository.save(investment);

        return newAcct;
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
        SecurityHolding newHolding = new SecurityHolding(account, security, numShares, security.getCurrentPrice()*numShares, security.getCurrentPrice(), LocalDate.now());

        account.setBalance(account.getBalance() + security.getCurrentPrice()*numShares);

        Transaction transaction = new Transaction(TransactionType.SECURITY_PURCHASED,
                security.getCurrentPrice()*numShares,
                account,
                String.format("%.2f shares of %s(%s) purchased at $%,.2f/share",numShares,security.getName(),security.getSymbol(),security.getCurrentPrice()),
                LocalDate.now(),
                account.getBalance()+security.getCurrentPrice()*numShares);
        transactionService.createTransaction(transaction);

        return securityHoldingRepository.save(newHolding);
    }

    public void sellHolding(long holdingId) {
        SecurityHolding holding = securityHoldingRepository.findById(holdingId).get();

        holding.getAccount().setBalance(holding.getAccount().getBalance() - holding.getValue());

        Transaction transaction = new Transaction(TransactionType.SECURITY_LIQUIDATED,
                -holding.getValue(),
                holding.getAccount(),
                String.format("%.2f shares of %s(%s) sold at $%,.2f/share",holding.getNumShares(),holding.getSecurity().getName(),holding.getSecurity().getSymbol(),holding.getSecurity().getCurrentPrice()),
                LocalDate.now(),
                holding.getAccount().getBalance());
        transactionService.createTransaction(transaction);

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
