package com.atm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "account")
@Entity
@Getter
@Setter
public class AccountEntity extends BaseEntity{

    @Column(name = "accountnumber",unique = true)
    private String accountNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "typeaccount")
    private Integer typeAccount;

    @Column(name = "balance")
    private Long balance;
    @Column(name = "status")
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "customerid")
    private CustomerEntity customer;

}
