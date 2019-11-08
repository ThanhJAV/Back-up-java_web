package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.repository.ProductRepositorySpringData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    //private ProductRepositorySpringData productRepositorySpringData;

    @Override
    public List<Product> findAllHaveBusiness() {
        return productRepository.findAll();
        //return productRepositorySpringData.findAll();
    }

    @Override
    public void addHaveBusiness(Product product) {
        productRepository.add(product);
        //productRepositorySpringData.save(product);
    }

    /*@Override
    public Product findById(Long id) {
        //return productRepository.findById(id);
        return productRepositorySpringData.findOne(id);
    }

    @Override
    public Iterable<Product> findByName(String name) {
        return productRepositorySpringData.findTop3ByName(name);
    }*/
}
