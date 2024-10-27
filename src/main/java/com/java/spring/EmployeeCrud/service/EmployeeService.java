package com.java.spring.EmployeeCrud.service;

import java.util.List;

import com.java.spring.EmployeeCrud.dto.EmployeeDto;
import com.java.spring.EmployeeCrud.exception.EmployeeNotFoundException;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeedto);
	EmployeeDto getEmployeeById(long employeeid) throws EmployeeNotFoundException;
	List<EmployeeDto> getEmployees();
	void deleteEmployee(Long employeeId) throws EmployeeNotFoundException;
	EmployeeDto updateEmployee(EmployeeDto employeedto) throws EmployeeNotFoundException;
}
