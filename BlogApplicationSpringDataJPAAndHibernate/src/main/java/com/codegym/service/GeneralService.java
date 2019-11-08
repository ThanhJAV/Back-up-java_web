package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface GeneralService<E> {
    Iterable<E> findAllHaveBusiness();
    E findById(Long id);
    void addHaveBusiness (E e);
    void save(E e);
    void remove(Long id);
    Iterable<Blog> findByName(String name);
}
