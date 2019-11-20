package com.codegym.model;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.List;
@Component
@Entity
@Table(name = "category")
public class Category implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employeeList;

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Category.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Category category = (Category) target;
        String name = category.getName();
        ValidationUtils.rejectIfEmpty(errors, "name", "category.empty");
//        if(category.length()>10 || category.length()<5) {
//            errors.rejectValue("category", "category.length");
//        }
//        if (!category.startWith("0,1,2,3,4,5,6,7,8,9")){
//            errors.rejectValue("category", "category.startWith");
//        }
//        if (!category.matches("(^$|[0-9]*$)")){
//            errors.rejectValue("number", "number.matches");
//        }


    }
}

