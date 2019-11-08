package com.codegym.controller;

import com.codegym.model.EmployeeForm;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import com.codegym.model.Department;
import com.codegym.model.Employee;
import com.codegym.service.DepartmentService;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Controller
@PropertySource("classpath:global_config_app.properties")
public class EmployeeController {

    @Autowired
    Environment env;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list-employee")
    public ModelAndView listEmployee(@PageableDefault(value = 5, sort = "salary") Pageable pageable, @RequestParam("s") Optional<String> s) {
//        Page<Employee> employee = employeeService.findAll(pageable);
        Page<Employee> employee;
        if(s.isPresent()){
             employee = employeeService.findAllByName(s.get(), pageable);
             employee = employeeService.findAllByDepartmentName(s.get(), pageable);
        } else {
            employee = employeeService.findAll(pageable);
        }

        if(s.isPresent()){
            employee = employeeService.findAllByName(s.get(), pageable);
        } else {
            employee = employeeService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("employee/list-employee");
        modelAndView.addObject("employees", employee);
        return modelAndView;
    }

    @GetMapping("/create-employee")
    public ModelAndView getCreateEmployee() {
        ModelAndView modelAndView = new ModelAndView("employee/create-employee");
        modelAndView.addObject("employee",new EmployeeForm());
        return modelAndView;
    }

    @PostMapping("/save-create-employee")
    public ModelAndView postCreateEmployee(@ModelAttribute EmployeeForm employeeForm, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Result Error Occured" + result.getAllErrors());
        }
        // lay ten file
        MultipartFile multipartFile = employeeForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();
        // luu file len server
        try {
            FileCopyUtils.copy(employeeForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // tham khảo: https://github.com/codegym-vn/spring-static-resources
        Employee employeeObject = new Employee(employeeForm.getName(), employeeForm.getBirthDate(), employeeForm.getAddress(),
                                               fileName, employeeForm.getSalary(), employeeForm.getDepartment());
        employeeService.save(employeeObject);
        ModelAndView modelAndView = new ModelAndView("redirect:/create-employee");
        modelAndView.addObject("employee", new EmployeeForm());
        modelAndView.addObject("message", "Employee created success");
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
    public ModelAndView  PostEditEmployee(@ModelAttribute("employee") Employee employee, RedirectAttributes redirect){
        employeeService.save(employee);

        ModelAndView modelAndView = new ModelAndView("redirect:/list-employee");
//        modelAndView.addObject("employee", new Employee());
        redirect.addFlashAttribute("message", "Employee updated successfully");
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
