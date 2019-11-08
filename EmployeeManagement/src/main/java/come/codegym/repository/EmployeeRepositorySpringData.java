package come.codegym.repository;

import come.codegym.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepositorySpringData extends PagingAndSortingRepository<Employee, Long> {
}
