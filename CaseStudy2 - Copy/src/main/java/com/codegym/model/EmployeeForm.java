package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class EmployeeForm {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private MultipartFile image;
    private String salary;

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmployeeForm(Long id, String name, LocalDate birthDate, String address, MultipartFile image, String salary, Department department) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.image = image;
        this.salary = salary;
        this.department = department;
    }

    public EmployeeForm() {
    }

    public EmployeeForm(Long id, String name, LocalDate birthDate, String address, MultipartFile image, String salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.image = image;
        this.salary = salary;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
