package com.atm.processor;

import com.atm.entity.AccountEntity;
import com.atm.entity.AtmEntity;
import com.atm.model.Account;
import com.atm.service.impl.AccountService;
import com.atm.service.impl.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AtmProcessor {
    @Autowired
    private AtmService atmService;
    @Autowired
    private AccountService accountService;
    @Transactional
    public  Long pickMoney(Long atmId, Account account) throws Exception {

        AtmEntity atmEntity = atmService.findByIdAndStatus(atmId,1);
        if (atmEntity==null){
            throw new Exception("Cannot found Atm");
        }
        AccountEntity accountEntity = accountService.findByAccountNumberAndStatus(account.getAccountNumber(),1);
        if (accountEntity==null){
            throw new Exception("Cannot found Account");
        }
        if (accountEntity.getBalance()<account.getAmountOfMoney()){
            throw new Exception("Your Account not enough money! ");
        }
        if (atmEntity.getTotalMoney()<account.getAmountOfMoney()){
            throw new Exception("Atm not enought money!");
        }
        Thread thread = new Thread(){
            @Override
            public void run() {
                accountService.pickMoney(accountEntity,account.getAmountOfMoney());
                atmService.pickMoney(atmEntity,account.getAmountOfMoney());
            }
        };
        thread.start();


        return account.getAmountOfMoney();
    }
}
