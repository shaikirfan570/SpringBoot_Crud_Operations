package com.java.spring.EmployeeCrud.dto;


public class EmployeeDto {
	
	public long Id;
	
	public String name;
	
	public  String city;
		
	public String department;	
	
	public int salary;

	public EmployeeDto(long id, String name, String city, String department, int salary) {
		super();
		Id = id;
		this.name = name;
		this.city = city;
		this.department = department;
		this.salary = salary;
	}

	public EmployeeDto() {
		super();
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
