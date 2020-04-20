package com.atm.converter;

import com.atm.entity.AtmEntity;
import com.atm.model.Atm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtmConverter implements CommonConverter<AtmEntity, Atm> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public AtmEntity toEntity(Atm atm) {
        AtmEntity atmEntity = modelMapper.map(atm,AtmEntity.class);
        return atmEntity;
    }

    @Override
    public Atm toModel(AtmEntity atmEntity) {
        Atm atm = modelMapper.map(atmEntity,Atm.class);
        return atm;
    }
}
