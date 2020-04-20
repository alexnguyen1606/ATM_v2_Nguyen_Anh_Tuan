package com.atm.service.impl;

import com.atm.entity.AtmEntity;
import com.atm.repository.AtmRepository;
import com.atm.service.CommonService;
import com.atm.service.IAtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtmService implements IAtmService, CommonService<AtmEntity> {
    @Autowired
    private AtmRepository atmRepository;
    @Override
    public AtmEntity findById(Long id) {
        return atmRepository.findById(id).get();
    }

    @Override
    public AtmEntity findByIdAndStatus(Long id, Integer status) {
        return atmRepository.findByIdAndStatus(id,status);
    }
    public synchronized void pickMoney(AtmEntity atmEntity,Long amountOfMoney){
        atmEntity.setTotalMoney(atmEntity.getTotalMoney()-amountOfMoney);
        atmRepository.save(atmEntity);
    }
}
