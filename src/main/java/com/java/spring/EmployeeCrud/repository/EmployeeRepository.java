package com.java.spring.EmployeeCrud.repository;


import com.java.spring.EmployeeCrud.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
