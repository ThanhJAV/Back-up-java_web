package come.codegym.service;

import come.codegym.model.Employee;

public interface GeneralService<E> {
    Iterable<E> findAllHaveBusiness();
    E findById(Long id);
    void addHaveBusiness (E e);
    void save(E e);
    void remove(Long id);
    Iterable<Employee> findByName(String name);
}
