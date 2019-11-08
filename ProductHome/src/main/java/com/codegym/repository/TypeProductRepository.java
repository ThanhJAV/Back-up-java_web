package com.codegym.repository;

import com.codegym.model.TypeProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TypeProductRepository extends PagingAndSortingRepository<TypeProduct,Long> {

}
