package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "employees")

public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private String image;
    private String salary;

    @ManyToOne
    @JoinColumn(name = "department_id")

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {
    }



    public Employee(String name, LocalDate birthDate, String address, String image, String salary, Department department) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.image = image;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String name, LocalDate birthDate, String address, String image, String salary) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.image = image;
        this.salary = salary;
    }

    public Employee(Long id, String name, LocalDate birthDate, String address, String image, String salary) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
