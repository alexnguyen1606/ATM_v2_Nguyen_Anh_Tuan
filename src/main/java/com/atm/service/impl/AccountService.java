package com.atm.service.impl;

import com.atm.entity.AccountEntity;
import com.atm.entity.QAccountEntity;
import com.atm.repository.AccountRepository;
import com.atm.service.CommonService;
import com.atm.service.IAccountService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Predicate;

@Service
public class AccountService implements IAccountService, CommonService<AccountEntity> {
    @Autowired
    private AccountRepository accountRepository;
    @PersistenceContext
    private EntityManager entityManager;
    private final QAccountEntity Q = QAccountEntity.accountEntity;
    public AccountEntity findByAccountNumber(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public AccountEntity findByAccountNumberAndStatus(String accountNumber,Integer status) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(Q.accountNumber.eq(accountNumber)).and(Q.status.eq(status));
        JPAQuery<AccountEntity> query = new JPAQuery<>(entityManager);

    return query.from(Q).where(builder).fetchOne();
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
