package com.atm.repository;

import com.atm.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
    AccountEntity findByAccountNumberAndStatus(String accountNumber,Integer status);
    AccountEntity findByAccountNumber(String accountNumber);
}
