package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;

    @NotEmpty(message = "Name is required field")
    @Size(min = 5, max = 30)
    @Pattern(regexp="^[A-Za-z]*$", message = "String must A-Za-z")

    private String name;
    private String email;
    private String phone;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Employee() {
    }

    public Employee(String name, String email, String phone, String gender, Category category) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.category = category;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
