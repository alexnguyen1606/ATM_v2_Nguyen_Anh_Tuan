package com.atm.service.impl;

import com.atm.entity.AccountEntity;
import com.atm.repository.AccountRepository;
import com.atm.service.CommonService;
import com.atm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService, CommonService<AccountEntity> {
    @Autowired
    private AccountRepository accountRepository;

    public AccountEntity findByAccountNumber(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public AccountEntity findByAccountNumberAndStatus(String accountNumber,Integer status) {
        return accountRepository.findByAccountNumberAndStatus(accountNumber,status);
    }

    @Override
    public synchronized void pickMoney(AccountEntity accountEntity, Long amountOfMoney) {
        accountEntity.setBalance(accountEntity.getBalance()-amountOfMoney);
        accountRepository.save(accountEntity);
    }

    @Override
    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public AccountEntity update(AccountEntity accountEntity) throws Exception {
        if (accountEntity.getId()==null){
            throw new Exception("Id is NULL");
        }

        return accountRepository.save(accountEntity);
    }
}
