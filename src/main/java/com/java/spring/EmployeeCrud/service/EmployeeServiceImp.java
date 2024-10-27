package com.java.spring.EmployeeCrud.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.EmployeeCrud.dto.EmployeeDto;
import com.java.spring.EmployeeCrud.entity.Employee;
import com.java.spring.EmployeeCrud.exception.EmployeeNotFoundException;
import com.java.spring.EmployeeCrud.mapper.EmloyeeMapper;
import com.java.spring.EmployeeCrud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	EmployeeRepository employeerepository;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeedto) {
		
		Employee employee = EmloyeeMapper.maptoEmployee(employeedto);
		Employee CreatedEmployee = employeerepository.save(employee);		
		return EmloyeeMapper.maptoEmployeeDto(CreatedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(long employeeid) throws EmployeeNotFoundException {
		Optional<Employee> employee =  employeerepository.findById(employeeid);
		
		if(employee.isEmpty()) {
			throw new EmployeeNotFoundException("The Employee With Id - " + employeeid + "is not Found");
		}
		 
		return EmloyeeMapper.maptoEmployeeDto(employee.get());		
	}

	@Override
	public List<EmployeeDto> getEmployees() {

      List<Employee> emplist =  employeerepository.findAll();		
		
      return emplist.stream().map(emp -> EmloyeeMapper.maptoEmployeeDto(emp)).collect(Collectors.toList());
	}

	@Override
	public void deleteEmployee(Long employeeId) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeerepository.findById(employeeId);
		
		if(employee.isEmpty()) {
			throw new EmployeeNotFoundException("The Employee Id " + employeeId + " is not foud to Delete" );
		}
		
		else {
			employeerepository.deleteById(employeeId);	
		}
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeedto) throws EmployeeNotFoundException {
		
		Optional<Employee> retrivedEmployee = employeerepository.findById(employeedto.getId());
		
		if(retrivedEmployee.isEmpty()) {
			throw new EmployeeNotFoundException("The Employee Id " + employeedto.getId() + " is not foud to update" );
		}
		
			
			Employee employee = retrivedEmployee.get();
			employee.setName(employeedto.getName());
			employee.setCity(employeedto.getCity());
			employee.setDepartment(employeedto.getDepartment());
			employee.setSalary(employeedto.getSalary());
			
			Employee updatedEmployee = employeerepository.save(employee);
		
			return EmloyeeMapper.maptoEmployeeDto(updatedEmployee);
	}

	
	
	
}
