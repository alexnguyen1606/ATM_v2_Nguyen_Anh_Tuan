package com.atm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @Column(name = "identifier",unique = true)
    private String identifier;

    private String address;

    @OneToMany(mappedBy = "customer")
    private List<AccountEntity> accounts = new ArrayList<>();
}
