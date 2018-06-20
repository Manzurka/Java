package com.manzuraz.employees.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manzuraz.employees.model.Employee;
import com.manzuraz.employees.service.EmployeeService;

@Controller
public class EmployeesController {
	private final EmployeeService es;
	
	public EmployeesController(EmployeeService es) {
		this.es=es;
	}
	
	@RequestMapping("/")
	public String index(Model m) {
		//create employees:
//   	Employee employee1 = es.addEmployee("Kate", "Moss");
//		Employee employee2 = es.addEmployee("Carmen", "Lopez");
//		Employee employee3 = es.addEmployee("Sean", "Paul");
		
		//find manager and employees by name then add employees
		Employee manager = es.findByName("Kate", "Moss");
//		List<Employee> employees = new ArrayList<Employee>(); 
//		Employee employee1 = es.findByName("Carmen", "Lopez");
//		Employee employee2 = es.findByName("Sean", "Paul");
//		employees.add(employee1);
//		employees.add(employee2);
//		manager.setEmployees(employees);  
//		es.findByName("Carmen", "Lopez").setManager(manager); 
//		es.findByName("Sean", "Paul").setManager(manager); 
		List<Employee> list = manager.getEmployees();
		for(Employee e: list) {
			System.out.println(e.getFirstName()); //print in console to test the getters
		}
		
		m.addAttribute("list", list); // draft version, not tested. 
		m.addAttribute("manager", manager);
		return "index.jsp"; // c:out not tested.
	}
}
