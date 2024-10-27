package com.java.spring.EmployeeCrud.mapper;

import com.java.spring.EmployeeCrud.dto.EmployeeDto;
import com.java.spring.EmployeeCrud.entity.Employee;

public class EmloyeeMapper {

	public static EmployeeDto maptoEmployeeDto(Employee employee) {
		
		return new EmployeeDto(employee.getId(), employee.getName(), employee.getCity(), employee.getDepartment(), employee.getSalary());
		
	}
	
	
	public static Employee maptoEmployee(EmployeeDto employeedto) {
		
		return new Employee(employeedto.getId(), employeedto.getName(), employeedto.getCity(), employeedto.getDepartment(), employeedto.getSalary());
		
	}
	
}
