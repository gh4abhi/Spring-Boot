package com.dev.crud.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.dev.crud.dao.EmployeeDao;
import com.dev.crud.entity.Employee;

@SpringBootApplication
@ComponentScan(basePackages = "com.dev.crud.*")
@EntityScan(basePackages = {"com.dev.crud.*"})
public class ControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDao empDAO)
	{
		return runner -> {
//			createEmployee(empDAO);
			displayAllEmployee(empDAO);
		};
	}
	
	public void createEmployee(EmployeeDao empDAO)
	{
		Employee emp = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee First Name");
		String fName = sc.nextLine();
		System.out.println("Enter Employee Last Name");
		String lName = sc.nextLine();
		System.out.println("Enter Employee Email");
		String email = sc.nextLine();
		emp.setFirstName(fName);
		emp.setLastName(lName);
		emp.setEmail(email);
		empDAO.save(emp);
		System.out.println("Employee saved with id : " + emp.getId());
	}
	
	public void displayAllEmployee(EmployeeDao empDAO)
	{
		List<Employee> empList= empDAO.findAllEmployee();
		for(Employee e : empList)
			System.out.println(e.toString());
		System.out.println(empList.toString());
	}
	
}
