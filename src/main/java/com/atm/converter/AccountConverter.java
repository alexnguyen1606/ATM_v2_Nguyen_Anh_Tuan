package com.atm.converter;

import com.atm.entity.AccountEntity;
import com.atm.model.Account;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface AccountConverter extends CommonConverter<AccountEntity, Account> {

    @Override
    AccountEntity toEntity(Account account);

    @Mapping(source = "customer.fullName",target = "fullName")
    @Override
    Account toModel(AccountEntity accountEntity);
}
