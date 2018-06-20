package com.manzuraz.employees.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	@Size(min=2, max=15)
	private String firstName;
	
	@Column 
	@Size(min=2, max=15)
	private String lastName;
	
	@OneToMany(mappedBy="manager", fetch=FetchType.LAZY)
	private List<Employee> employees;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee manager;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date createdAt;

	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
	
	public Employee() {
		
	}
	
	public Employee(String f, String l) {
		firstName=f;
		lastName=l;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}

