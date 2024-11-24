package com.spring.boot.rest.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.rest.crud.entity.Student;
import com.spring.boot.rest.crud.exception.StudentErrorResponse;
import com.spring.boot.rest.crud.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> studentList;
	
	@PostConstruct
	public void loadData()
	{
		studentList = new ArrayList<>();
		studentList.add(new Student("Abhishek", "Swaroop"));
		studentList.add(new Student("Midoriya", "Izuku"));
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		
		return studentList;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId)
	{
		if(studentId<0 || studentId>=studentList.size())
			throw new StudentNotFoundException("Student id not found - " + studentId);
		
		return studentList.get(studentId);
	}
}
