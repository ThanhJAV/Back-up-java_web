package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

//@RepositoryDefinition(domainClass = Product.class, idClass = Long.class)
public interface ProductRepositorySpringData extends PagingAndSortingRepository<Product, Long>{

    Iterable<Product> findTop3ByName(String name);

}
