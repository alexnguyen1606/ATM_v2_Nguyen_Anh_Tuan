package com.atm.converter;

import com.atm.entity.CustomerEntity;
import com.atm.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter implements CommonConverter<CustomerEntity, Customer> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CustomerEntity toEntity(Customer customer) {
        CustomerEntity customerEntity = modelMapper.map(customer,CustomerEntity.class);
        return customerEntity;
    }

    @Override
    public Customer toModel(CustomerEntity customerEntity) {
        Customer customer = modelMapper.map(customerEntity,Customer.class);
        return customer;
    }
}
