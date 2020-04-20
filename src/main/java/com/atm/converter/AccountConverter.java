package com.atm.converter;

import com.atm.entity.AccountEntity;
import com.atm.model.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AccountConverter implements CommonConverter<AccountEntity, Account> {

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public AccountEntity toEntity(Account account){
        AccountEntity accountEntity = modelMapper.map(account,AccountEntity.class);
        return accountEntity;
    }

    @Override
    public Account toModel(AccountEntity accountEntity){
        Account account = modelMapper.map(accountEntity,Account.class);
        account.setFullName(accountEntity.getCustomer().getFullName());
        return account;
    }
}
