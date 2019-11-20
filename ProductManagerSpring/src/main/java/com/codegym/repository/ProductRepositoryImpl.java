package com.codegym.repository;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    List<Product> productList = new ArrayList<>();

    {
        productList.add(new Product(1, "Samsung", 300d));
        productList.add(new Product(2, "Iphone", 400d));
        productList.add(new Product(3, "Nokia", 500d));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }
}
