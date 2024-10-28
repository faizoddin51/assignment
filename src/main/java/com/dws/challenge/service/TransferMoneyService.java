package com.dws.challenge.service;

import com.dws.challenge.domain.Account;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class TransferMoneyService {

    @Autowired
    private final AccountsService accountsService;
    @Autowired
    private final EmailNotificationService emailNotificationService;

    public void transferMoney(String accountFrom, String accountTo, BigDecimal amount){
        Account sourceAccount = accountsService.getAccount(accountFrom);
        if(sourceAccount != null){
            Account targetAccount = accountsService.getAccount(accountTo);
            if(sourceAccount.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0){
                emailNotificationService.notifyAboutTransfer(sourceAccount,"Insufficient funds!");
            } else {
                accountsService.updateAccoutBalence(accountFrom,sourceAccount.getBalance().subtract(amount));
                accountsService.updateAccoutBalence(accountTo,targetAccount.getBalance().add(amount));
                emailNotificationService.notifyAboutTransfer(sourceAccount,"Account is debitted with: "+amount);
                emailNotificationService.notifyAboutTransfer(targetAccount,"Account is creditted with: "+amount);
            }
        } else {
            emailNotificationService.notifyAboutTransfer(new Account(accountFrom, BigDecimal.ZERO),"Account from is not not valid");
        }
    }
}
