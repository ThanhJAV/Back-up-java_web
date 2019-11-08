package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(Long id);

    void save(Product product );

    void remove(Long id);

    Page<Product> findAllByName (String name, Pageable pageable);

    Page<Product> findAllByTypeProductName(String name, Pageable pageable);
}
