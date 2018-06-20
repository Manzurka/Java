package com.manzuraz.employees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.manzuraz.employees.model.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
	List<Employee>findAll();
	
	@Query("SELECT e FROM Employee AS e WHERE first_name = ?1 AND last_name = ?2")
	Employee findByName(String firstName, String lastName);
}
