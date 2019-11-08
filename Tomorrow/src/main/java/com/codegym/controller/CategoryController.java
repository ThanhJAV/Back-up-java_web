package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list-gender")
    public ModelAndView getCreateForm(Pageable pageable) {
        Page<Category> categories = categoryService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/list-gender" );
        modelAndView.addObject("category", categories);
        return modelAndView;
    }

    @GetMapping("/create-gender")
    public ModelAndView listCategory() {
//        Page<TypeProduct> typeProducts = typeProductService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/create-gender");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }

    @PostMapping("/save-create-gender")
    public ModelAndView postCreateCategory(@ModelAttribute Category gender, RedirectAttributes redirect) {
        categoryService.save(gender);
        ModelAndView modelAndView =new ModelAndView("redirect:/list-gender");
        modelAndView.addObject("category", new Category());
        redirect.addFlashAttribute("message", "category created success");
        return modelAndView;
    }





}
