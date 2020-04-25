package com.atm.converter;

import com.atm.entity.CustomerEntity;
import com.atm.model.Customer;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CustomerConverter extends CommonConverter<CustomerEntity, Customer> {
    @Override
    CustomerEntity toEntity(Customer customer);

    @Override
    Customer toModel(CustomerEntity customerEntity);

}
