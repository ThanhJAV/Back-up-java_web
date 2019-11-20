package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllHaveBusiness() {
        return productRepository.findAll();
    }

    @Override
    public void addHaveBusiness(Product product) {
        productRepository.add(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public void remove(Long id){

        productRepository.remove(id);
    }


}
