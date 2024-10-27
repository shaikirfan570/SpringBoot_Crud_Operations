package com.java.spring.EmployeeCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.java.spring.EmployeeCrud.dto.EmployeeDto;
import com.java.spring.EmployeeCrud.exception.EmployeeNotFoundException;
import com.java.spring.EmployeeCrud.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeservice;
	
	@PostMapping(value = "/employee")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeedto ){
		EmployeeDto createdEmployee = employeeservice.createEmployee(employeedto);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/employee/{employeeId}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException{
		
		try {
			EmployeeDto employeedto = employeeservice.getEmployeeById(employeeId);
		    return new ResponseEntity<>(employeedto, HttpStatus.OK);
		}
		
		catch(EmployeeNotFoundException employeenotfoundexception){
			throw employeenotfoundexception;
		}
		
	}
	
	@GetMapping(value = "/employee")
	public ResponseEntity<List<EmployeeDto>> getEmployees(){
		
		List<EmployeeDto> employees = employeeservice.getEmployees();
		
		return new ResponseEntity<>(employees, HttpStatus.OK);		
	}
	
	@DeleteMapping(value = "/employee/{employeeid}")
	public ResponseEntity<HttpStatus> deleteEmpbyId(@PathVariable("employeeid") Long employeeid ) throws EmployeeNotFoundException{
		try{
			employeeservice.deleteEmployee(employeeid);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		catch(EmployeeNotFoundException e) {
			throw e;
		}
		
	}
	
	@PutMapping(value = "/employee")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeedto ) throws EmployeeNotFoundException{
		try
		{
		EmployeeDto updatedEmployee = employeeservice.updateEmployee(employeedto);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.CREATED);
		}
		
		catch(EmployeeNotFoundException e) {
			throw e;
		}
	}
}
