package com.codegym.service;

import com.codegym.model.Blog;
//import com.codegym.repository.BlogRepository;
import com.codegym.repository.BlogRepositorySpringData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {

    @Autowired
//    private BlogRepository blogRepository;
    private BlogRepositorySpringData blogRepositorySpringData;

//    @Override
//    public List<Blog> findAllHaveBusiness() {
//        return blogRepository.findAll();
//    }

    @Override
    public Iterable<Blog> findAllHaveBusiness() {
        return blogRepositorySpringData.findAll();
    }

//    @Override
//    public Blog findById(Long id) {
//        return blogRepository.findById(id);
//    }

    @Override
    public Blog findById(Long id) {
        return blogRepositorySpringData.findOne(id);
    }

//    @Override
//    public void addHaveBusiness(Blog blog) {
//        blogRepository.add(blog);
//    }

    @Override
    public void addHaveBusiness(Blog blog) {
        blogRepositorySpringData.save(blog);
    }

//    @Override
//    public void save(Blog blog) {
//        blogRepository.save(blog);
//    }

    @Override
    public void save(Blog blog) {
        blogRepositorySpringData.save(blog);
    }

//    @Override
//    public void remove(Long id) {
//        blogRepository.remove(id);
//    }

    @Override
    public void remove(Long id) {
        blogRepositorySpringData.delete(id);
    }

    @Override
    public Iterable<Blog> findByName(String name) {
        return blogRepositorySpringData.findBlogByAuthor(name);
    }
}
