package com.spring.dev.crud.dao;

import java.util.List;

import com.spring.dev.crud.entity.Student;

public interface StudentDAO {
	
	void save(Student student);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String lastName);
}
