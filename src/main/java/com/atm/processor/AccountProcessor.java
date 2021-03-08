package com.atm.processor;

import com.atm.converter.AccountConverter;
import com.atm.entity.AccountEntity;
import com.atm.model.Account;
import com.atm.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountProcessor  {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountConverter converter;
    public Account findByAccountNumber(String accountNumber) throws Exception {
        if (accountNumber.equals("")){
            throw new Exception("AccounNumber is null");
        }
        AccountEntity accountEntity = accountService.findByAccountNumberAndStatus(accountNumber,1);
        if (accountEntity == null){
            throw new Exception("Account Null");
        }
        Account account = converter.toModel(accountEntity);
        return account;
    }


    public List<Account> findAll() {
        return accountService.findAll().stream().map(item -> converter.toModel(item)).collect(Collectors.toList());
    }


    public void enable(String accountNumber) {
        AccountEntity accountEntity = accountService.findByAccountNumber(accountNumber);
        accountEntity.setStatus(1);
        try {
            accountService.update(accountEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void disable(String accountNumber) {
        AccountEntity accountEntity = accountService.findByAccountNumber(accountNumber);
        accountEntity.setStatus(0);
        try {
            accountService.update(accountEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
