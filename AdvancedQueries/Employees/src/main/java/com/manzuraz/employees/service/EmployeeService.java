package com.manzuraz.employees.service;

import org.springframework.stereotype.Service;

import com.manzuraz.employees.model.Employee;
import com.manzuraz.employees.repository.EmployeeRepo;

@Service
public class EmployeeService {
	private final EmployeeRepo er;
	
	public EmployeeService(EmployeeRepo er) {
		this.er=er;
	}
	public Employee addEmployee(String f, String l) {
		Employee e = new Employee(f,l);
		return er.save(e);
	}
	
	public Employee findByName(String firstName, String lastName) {
		return er.findByName(firstName,lastName);
	}

}
