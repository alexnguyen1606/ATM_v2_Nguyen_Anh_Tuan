package com.atm.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Customer {
    private String fullName;
    private String address;
    private Date dateOfBirth;
}
