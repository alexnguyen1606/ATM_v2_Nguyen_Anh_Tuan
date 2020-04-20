package com.atm.service;

import java.util.List;

public interface  CommonService<E> {
   default E findById(Long id) {
        return null;
    }

    default List<E> findAll() {
        return null;
    }
    default E save(E e){
       return null;
    };
   default E update(E e) throws Exception {return  null;};

}
