package com.codegym.controller;


import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.Id;
import java.util.List;

@Controller
//@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

//    @GetMapping("/list")
//    public ModelAndView findAll(){
//        Product product = productService.findById(Long.valueOf("2"));
//        List<Product> productList = productService.findAllHaveBusiness();
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("products" , productList);
//        return modelAndView;
//    }

    @GetMapping("/list")
    public String getIndex(Model model){
        List<Product> productList = productService.findAllHaveBusiness();
        model.addAttribute("products",productList);
        return "/list";
    }

//    @GetMapping("/create-product")
//    public ModelAndView createForm(){
//        ModelAndView modelAndView = new ModelAndView("/create");
//        modelAndView.addObject("product" , new Product());
//        return modelAndView;
//    }


    @GetMapping("/create-product")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }


//    @PostMapping("/save-product")
////    Model model
//    public ModelAndView saveProduct(@ModelAttribute("product") Product product , RedirectAttributes redirect) {
//        productService.addHaveBusiness(product);
////      model.addAttribute("products",productService.findAllHaveBusiness());
//        ModelAndView modelAndView = new ModelAndView("redirect:/create-product");
////        ModelAndView modelAndView = new ModelAndView("/create");
////        modelAndView.addObject("product",new Product());
//        redirect.addFlashAttribute("message", "Saved customer successfully!");
//        return modelAndView;
////
//    }

    @PostMapping("/save-product")
    public String save(Product product , RedirectAttributes redirect){
        productService.addHaveBusiness(product);
        redirect.addFlashAttribute("message", "Saved customer successfully!");
        return "redirect:/create-product";
    }


    @GetMapping("/edit-product/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }


    @PostMapping("/edit-product")
    public String update(Product product , RedirectAttributes redirect){
        productService.save(product);
        redirect.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/list";
    }

//    @GetMapping("/edit-product/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id){
//        Product product = productService.findById(id);
//        if(product != null) {
//            ModelAndView modelAndView = new ModelAndView("/edit");
//            modelAndView.addObject("product", product);
//            return modelAndView;
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit-product")
//    public ModelAndView updateCustomer(@ModelAttribute("product") Product product){
//        productService.save(product);
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("products", product);
//        modelAndView.addObject("success", "Customer updated successfully");
//        return modelAndView;
//    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("product", product);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

//    @PostMapping("/delete-product")
//    public ModelAndView deleteProduct(@PathVariable Product product){
//        productService.remove(product.getId());
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("success", "Product delete successfully");
//       return modelAndView;
//    }

    @PostMapping("/delete-product")
    public String deleteCustomer(@ModelAttribute("product") Product product, RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Product delete successfully!");
        return "redirect:/list";
    }

//    @PostMapping("/delete-customer")
//    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
//        customerService.remove(customer.getId());
//        return "redirect:customers";
//    }

    @GetMapping("/view-product/{id}")
    public String view(@PathVariable long id , Model model){
        model.addAttribute("product",productService.findById(id));
        return "/view";
    }


}

