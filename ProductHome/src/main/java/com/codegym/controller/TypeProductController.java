package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.TypeProduct;
import com.codegym.service.TypeProductService;
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
public class TypeProductController {
    @Autowired
    private TypeProductService typeProductService;

    @GetMapping("/list-type")
    public ModelAndView getCreateForm(Pageable pageable) {
        Page<TypeProduct> typeProducts = typeProductService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/list-type" );
        modelAndView.addObject("type", typeProducts);
        return modelAndView;
    }

    @GetMapping("/create-type")
    public ModelAndView listType() {
//        Page<TypeProduct> typeProducts = typeProductService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/create-type");
        modelAndView.addObject("typeproduct",new TypeProduct());
        return modelAndView;
    }

    @PostMapping("/save-create-type")
    public ModelAndView postCreateProduct(@ModelAttribute TypeProduct typeProduct, RedirectAttributes redirect) {
        typeProductService.save(typeProduct);
        ModelAndView modelAndView =new ModelAndView("redirect:/create-type");
        modelAndView.addObject("type-product", new TypeProduct());
        redirect.addFlashAttribute("message", "Type product created success");
        return modelAndView;
    }
}
