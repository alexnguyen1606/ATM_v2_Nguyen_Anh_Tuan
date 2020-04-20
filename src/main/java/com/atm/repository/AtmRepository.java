package com.atm.repository;

import com.atm.entity.AtmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmRepository extends JpaRepository<AtmEntity,Long> {
    AtmEntity findByIdAndStatus(Long id,Integer status);
}
