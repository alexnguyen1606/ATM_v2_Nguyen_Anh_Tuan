package com.atm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Atm {
    private Long id;
    private Long totalMoney;
    private Account account;

}
