package com.dev.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.crud.entity.Employee;
import com.dev.crud.repository.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDao implements EmployeeRepository{
	
	EntityManager entManager;
	
	@Autowired
	public EmployeeDao(EntityManager entManager) {
		this.entManager = entManager;
	}
	
	@Override
	@Transactional
	public void save(Employee emp)
	{
		entManager.persist(emp);
	}
	
	@Override
	public List<Employee> findAllEmployee()
	{
		TypedQuery<Employee> custQuery = entManager.createQuery("From Employee e order by e.id", Employee.class);
		return custQuery.getResultList();
	}
	
}
