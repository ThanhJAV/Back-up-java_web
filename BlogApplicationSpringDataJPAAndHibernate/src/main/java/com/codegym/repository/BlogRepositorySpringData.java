package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepositorySpringData extends PagingAndSortingRepository<Blog , Long> {
    Iterable<Blog> findBlogByAuthor(String name);

}
