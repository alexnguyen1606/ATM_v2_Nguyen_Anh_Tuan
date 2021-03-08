package com.atm.converter;

public interface CommonConverter<E, M> {

  E toEntity(M m);

  M toModel(E e);
}
