package com.dev.crud.repository;

import java.util.List;

import com.dev.crud.entity.Employee;

public interface EmployeeRepository {
	
	void save(Employee emp);
	List<Employee> findAllEmployee();
}
