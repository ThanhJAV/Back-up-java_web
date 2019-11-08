package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface GeneralService<E> {
    List<E> findAllHaveBusiness();
    void addHaveBusiness(E e);
    //E findById(Long id);
    //Iterable<Product> findByName(String name);

}
