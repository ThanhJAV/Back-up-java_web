package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.model.Category;
import com.codegym.service.EmployeeService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("category")
    public Page<Category> categories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @GetMapping("/list-employee")
    public ModelAndView listEmployee(@PageableDefault(value = 5) Pageable pageable, @RequestParam("s") Optional<String> s) {

        Page<Employee> employees;
        employeeService.findAll(pageable);
        if(s.isPresent()){
            employees = employeeService.findAllByName(s.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }

//        Page<Employee> employees =  employeeService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("/list");
            modelAndView.addObject("employee", employees);
            return modelAndView;
        }


    @GetMapping("/create-employee")
    public ModelAndView listProduct(Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("employee",new Employee());
        return modelAndView;
    }

    @PostMapping("/save-create-employee")
    public ModelAndView postCreateProduct(@ModelAttribute("product") @Validated Employee employee, BindingResult result, RedirectAttributes redirect) {

        if (result.hasErrors()) {
            System.out.println("Result Error Occured" + result.getAllErrors());
            ModelAndView modelAndView = new ModelAndView("/create");
            modelAndView.addObject("employee", new Employee());
            return modelAndView;
        }
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("redirect:/create-employee");
        modelAndView.addObject("employee", new Employee());
        redirect.addFlashAttribute("message", "Employee created success");
        return modelAndView;
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView getEditEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/save-edit-employee")
    public String  PostEditEmployee(Employee employee, RedirectAttributes redirect){
        employeeService.save(employee);
//        ModelAndView modelAndView = new ModelAndView("redirect:/list-product");
        redirect.addFlashAttribute("message", "Employee updated successfully");
        return "redirect:/list-employee";
    }

    @GetMapping("/delete-employee/{id}")
    public String delete(@PathVariable long id , Model model){
        model.addAttribute("employee",employeeService.findById(id));
        return "/delete";
    }

    @PostMapping("/save-delete-employee")
    public String delete(Employee employee, RedirectAttributes redirect){
        employeeService.remove(employee.getId());
        redirect.addFlashAttribute("message", "Removed employee successfully!");
        return "redirect:/list-employee";
    }

}
