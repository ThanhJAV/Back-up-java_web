package come.codegym.service;

import come.codegym.model.Employee;
import come.codegym.repository.EmployeeRepositorySpringData;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepositorySpringData employeeRepositorySpringData;



    @Override
    public Iterable<Employee> findAllHaveBusiness() {
        return employeeRepositorySpringData.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepositorySpringData.findOne(id);
    }

    @Override
    public void addHaveBusiness(Employee employee) {
        employeeRepositorySpringData.save(employee);
    }

    @Override
    public void save(Employee employee) {
        employeeRepositorySpringData.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepositorySpringData.delete(id);
    }

    @Override
    public Iterable<Employee> findByName(String name) {
        return null;
    }
}
