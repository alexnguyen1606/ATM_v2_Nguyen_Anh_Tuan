package com.atm.entity;

import com.atm.converter.AtmConverter;
import com.atm.converter.CustomerConverter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "atm")
@Entity
@Getter
@Setter
public class AtmEntity extends BaseEntity {
    @Column(name = "totalmoney")
    private Long totalMoney;
    @Column(name = "status",columnDefinition = "int default 1")
    private Integer status;
}
