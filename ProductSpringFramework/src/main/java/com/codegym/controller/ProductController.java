package com.codegym.controller;


import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
//(@RequestParam("s") Optional<String> s,
    @GetMapping("/list")
    public ModelAndView listProduct(Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
//        if (s.isPresent()) {
//            products = productService.findAllByName(s.get(), pageable);
//        } else {
//            products = productService.findAll(pageable);
//        }
//
//        if (s.isPresent()) {
//            products = productService.findAllByTypeProduct(s.get(), pageable);
//        } else {
//            products = productService.findAll(pageable);
//        }

        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("products", products);
        return modelAndView;


    }
}


