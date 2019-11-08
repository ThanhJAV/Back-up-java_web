package com.codegym.service.impl;

import com.codegym.model.Employee;
import com.codegym.repository.EmployeeRepository;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;




public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public Page<Employee> findAllByDepartmentName(String name, Pageable pageable) {
        return employeeRepository.findAllByDepartmentName(name,pageable);
    }

    @Override
    public Page<Employee> findAllByName(String name, Pageable pageable) {
        return employeeRepository.findAllByName( name,  pageable);
    }


//    @Override
//    public Page<Employee> findAllByNameAndDepartment(String name, Pageable pageable) {
//        return employeeRepository.findAllByNameAndDepartment(name, (java.awt.print.Pageable) pageable);
//    }


}
