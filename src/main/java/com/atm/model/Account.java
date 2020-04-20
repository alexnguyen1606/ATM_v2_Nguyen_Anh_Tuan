package com.atm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private String accountNumber;
    @JsonIgnore
    private String password;

    private Integer typeAccount;
    @JsonIgnore
    private Long balance;

    private Integer status;

    private String fullName;

    private Long amountOfMoney;

}
