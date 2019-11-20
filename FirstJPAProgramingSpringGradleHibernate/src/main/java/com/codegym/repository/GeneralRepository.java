package com.codegym.repository;

import java.util.List;

public interface GeneralRepository<E> {
    List<E> findAll();
    E findById(Long id);
    void add (E e);
    void save(E model);
    void remove(Long id);

}
