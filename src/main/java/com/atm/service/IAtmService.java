package com.atm.service;

import com.atm.entity.AtmEntity;

public interface IAtmService {
    AtmEntity findByIdAndStatus(Long id,Integer status);
}
