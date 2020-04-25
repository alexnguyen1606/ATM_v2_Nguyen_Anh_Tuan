package com.atm.converter;

import com.atm.entity.AtmEntity;
import com.atm.model.Atm;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AtmConverter extends CommonConverter<AtmEntity, Atm> {
    @Override
    AtmEntity toEntity(Atm atm);

    @Override
    Atm toModel(AtmEntity atmEntity);
}
