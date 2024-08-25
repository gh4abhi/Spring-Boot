package com.spring.dev.dao.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dev.crud.dao.StudentDAO;
import com.spring.dev.crud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Student student)
	{
		entityManager.persist(student);
	}

	@Override
	public Student findById(Integer id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}
	
	@Override
	public List<Student> findAll()
	{
		TypedQuery<Student> custQuery = entityManager.createQuery("From Student s", Student.class);
		return custQuery.getResultList();
	}
}
