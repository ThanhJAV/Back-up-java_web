//package com.codegym.repository;
//
//import com.codegym.model.Blog;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Transactional
//public class BlogRepositoryImpl implements BlogRepository {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public List<Blog> findAll() {
//        List<Blog> blogList = em.createNamedQuery("findAllBlog").getResultList();
//        return blogList;
//    }
//
//    @Override
//    public Blog findById(Long id) {
//        Blog blog = (Blog) em.createNamedQuery("findBlogById")
//                .setParameter("id" , id)
//                .getSingleResult();
//        return blog;
//    }
//
//    @Override
//    public void add(Blog blog) {
//        em.persist(blog);
//    }
//
//    @Override
//    public void save(Blog model) {
//        em.merge(model);
//    }
//
//    @Override
//    public void remove(Long id) {
//        Blog blog = findById(id);
//        if(blog != null){
//            em.remove(blog);
//        }
//    }
//}
