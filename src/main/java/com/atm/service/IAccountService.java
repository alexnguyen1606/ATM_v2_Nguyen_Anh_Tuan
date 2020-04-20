package com.atm.service;

import com.atm.entity.AccountEntity;

public interface IAccountService {
    AccountEntity findByAccountNumber(String accountNumber);
    AccountEntity findByAccountNumberAndStatus(String accountNumber,Integer status);
    void pickMoney(AccountEntity accountEntity,Long amountOfMoney);
}
