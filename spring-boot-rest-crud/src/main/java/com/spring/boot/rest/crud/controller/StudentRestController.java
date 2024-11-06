package com.spring.boot.rest.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.rest.crud.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Abhishek", "Swaroop"));
		studentList.add(new Student("Midoriya", "Izuku"));
		return studentList;
	}
	
}
