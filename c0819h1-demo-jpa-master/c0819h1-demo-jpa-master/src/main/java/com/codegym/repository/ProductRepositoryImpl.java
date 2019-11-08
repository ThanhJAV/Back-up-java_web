package com.codegym.repository;

import com.codegym.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAll() {
        List<Product> productList = em.createNamedQuery("findAllProduct")
                .getResultList();
        return productList;
    }

    @Override
    public Product findById(Long id) {
        Product product = (Product) em.createNamedQuery("findProductById")
                .setParameter("id", id)
                .getSingleResult();
        return product;
    }

    @Override
    public void add(Product product) {
        em.persist(product);
    }
}
