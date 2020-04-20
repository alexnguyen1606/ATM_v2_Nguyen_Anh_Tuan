package com.atm.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public interface CommonConverter <E,M> {

    E toEntity(M m);
    M toModel(E e);
}
