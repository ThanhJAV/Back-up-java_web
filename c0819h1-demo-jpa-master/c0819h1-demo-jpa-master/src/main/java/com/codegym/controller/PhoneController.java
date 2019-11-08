package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.codegym.model.PhoneNumber;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/phone")
    public String showForm(Model model){
        model.addAttribute("phonenumber", new PhoneNumber());
        return "/phone/index";
    }
    @PostMapping("/save-phone")
    public String checkValidation (@Valid @ModelAttribute("phonenumber")PhoneNumber phonenumber, BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phonenumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/phone/index";
        }
        else {
            model.addAttribute("phonenumber", phonenumber.getNumber());
            return "/phone/result";
        }
    }
}

