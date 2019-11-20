package com.codegym.repository;

import com.codegym.model.Product;
import com.codegym.model.TypeProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAllByName(String name, Pageable pageable);
    Page<Product> findAllByTypeProduct(String name, Pageable pageable);
}
