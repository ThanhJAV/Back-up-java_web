package com.codegym.controller;


import com.codegym.model.Department;
import com.codegym.model.Employee;
import com.codegym.service.DepartmentService;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list-employee")
    public ModelAndView listEmployee(Pageable pageable) {

        Iterable<Employee> employee = employeeService.findAll(pageable);

        ModelAndView modelAndView = new ModelAndView("employee/list-employee");
        modelAndView.addObject("employees", employee);
        return modelAndView;
    }

    @GetMapping("/create-employee")
    public ModelAndView getCreateEmployee() {

        ModelAndView modelAndView = new ModelAndView("employee/create-employee");
        modelAndView.addObject("employee",new Employee());
        return modelAndView;
    }

    @PostMapping("/save-create-employee")
    public ModelAndView postCreateEmployee(@ModelAttribute("employee") Employee employee, RedirectAttributes redirect) {
        employeeService.save(employee);

        ModelAndView modelAndView = new ModelAndView("redirect:/create-employee");
        modelAndView.addObject("employee", new Employee());
        redirect.addFlashAttribute("message", "Employee created success");
        return modelAndView;
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView getEditEmployee(@PathVariable Long id, Model model) {

        Employee employee = employeeService.findById(id);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("employee/edit-employee");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/save-edit-employee")
    public ModelAndView  PostEditEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);

        ModelAndView modelAndView = new ModelAndView("employee/edit-employee");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("message", "Employee updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-employee/{id}")
    public ModelAndView getDeleteEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("employee/delete-employee");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-employee")
    public String deleteBlog(@ModelAttribute("employee") Employee employee, RedirectAttributes redirect){
        employeeService.remove(employee.getId());
        redirect.addFlashAttribute("message", "Employee delete successfully!");
        return "redirect:/list-employee";
    }

    @ModelAttribute("departments")
    public Iterable<Department> departments(){
        return departmentService.findAll();
    }
}
