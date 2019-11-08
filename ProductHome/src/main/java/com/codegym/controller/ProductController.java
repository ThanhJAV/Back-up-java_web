package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.TypeProduct;
import com.codegym.service.ProductService;
import com.codegym.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private TypeProductService typeProductService;

    @ModelAttribute("type")
    public Page<TypeProduct> typeProducts(Pageable pageable){
        return typeProductService.findAll(pageable);
    }

    @GetMapping("/list-product")
    public ModelAndView listEmployee(@PageableDefault(value = 5, sort = "price") Pageable pageable, @RequestParam("s") Optional<String> s) {

        Page<Product> products;
        productService.findAll(pageable);
        if(s.isPresent()){
            products = productService.findAllByName(s.get(), pageable);
            products = productService.findAllByTypeProductName(s.get(), pageable);
        } else {
            products = productService.findAll(pageable);
        }

        if(s.isPresent()){
            products = productService.findAllByName(s.get(), pageable);
        } else {
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView listProduct(Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @PostMapping("/save-create-product")
    public ModelAndView postCreateProduct(@ModelAttribute("product") Product product, RedirectAttributes redirect) {
        productService.save(product);
        ModelAndView modelAndView =new ModelAndView("redirect:/create-product");
        modelAndView.addObject("product", new Product());
        redirect.addFlashAttribute("message", "Product created success");
        return modelAndView;
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView getEditProduct(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/edit-product");
            modelAndView.addObject("product", product);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/save-edit-product")
    public String  PostEditProduct(Product product, RedirectAttributes redirect){
        productService.save(product);
//        ModelAndView modelAndView = new ModelAndView("redirect:/list-product");
        redirect.addFlashAttribute("message", "Product updated successfully");
        return "redirect:/list-product";
    }

    @GetMapping("/delete-product/{id}")
    public String delete(@PathVariable long id , Model model){
        model.addAttribute("product",productService.findById(id));
        return "/delete-product";
    }

    @PostMapping("/save-delete-product")
    public String delete(Product product, RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/list-product";
    }
}
