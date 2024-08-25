package com.spring.dev.crud;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.spring.dev.crud.dao.StudentDAO;
import com.spring.dev.crud.entity.Student;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring.dev.*")
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {
			createStudent(studentDAO);
			findAllStudent(studentDAO);
		};
	}

	private void findAllStudent(StudentDAO studentDAO) {
	
		System.out.println("Displaying all students...");
		List<Student> students = studentDAO.findAll();
		for(Student s: students)
		{
			System.out.println(s.toString());
		}
		
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student");
		Student student = new Student("gh4","abhi","gh4@gmail.com");
		
		System.out.println("Saving student in database");
		studentDAO.save(student);
		
		System.out.println("Displaying student id");
		System.out.println(student.getId());
		
		System.out.println("Displaying student details...");
		
		Student st = studentDAO.findById(student.getId());
		
		System.out.println(st.toString());
		
	}
}
