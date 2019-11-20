package com.codegym.controller;


import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Name;
import java.util.List;

@Controller

public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/home")
    public String getIndex() {
        return "/home-page";
    }

    @GetMapping("/blog-list")
    public String getBlogList(Model model){
//        Iterable<Blog> blogListByName = blogService.findByName("Kim Dung");
//        List<Blog> blogList = blogService.findAllHaveBusiness();
        Iterable<Blog> blogList = blogService.findAllHaveBusiness();
        model.addAttribute("blog",blogList);
        return "/list";
    }

    @GetMapping("/create-blog")
    public String getCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save-create-blog")
    public String potsCreateBlog(Blog blog , RedirectAttributes redirect){
        blogService.addHaveBusiness(blog);
        redirect.addFlashAttribute("message", "Create blog successfully!");
        return "redirect:/create-blog";
    }

    @GetMapping("/edit-blog/{id}")
    public String getEditBlog( @PathVariable Long id , Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }
//
    @PostMapping("/save-edit-blog")
    public String postSaveEditBlog(Blog blog , RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Edit blog successfully!");
        return "redirect:/blog-list";
    }

//    @PostMapping("/save-edit-blog")
//    public ModelAndView updateCustomer(@ModelAttribute Blog blog){
//        blogService.save(blog);
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("blog", blog);
//        modelAndView.addObject("success", "Customer updated successfully");
//        return modelAndView;
//    }

    @GetMapping("/read-blog/{id}")
    public String getReadBlog( @PathVariable long id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "/read";
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView deleteBlogForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect){
        blogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Blog delete successfully!");
        return "redirect:/blog-list";
    }

    @GetMapping("/search-blog")
    public String searchBlog(Model model){
        model.addAttribute("blog", new Blog());
        return "/search-by-name";
    }

    @PostMapping("/search-blog")
    public ModelAndView postSearchBlog(@RequestParam String author) {
//        System.out.println(">> name:"+author);
        Iterable<Blog> blogListByName = blogService.findByName(author);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blog",blogListByName);
        modelAndView.addObject("success", "Find blog successfully!");
        return modelAndView;
    }

}

