package com.spring.dev.project.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectRestController {
	
	@GetMapping("/")
	public String sayHello()
	{
		return "Hello!";
	}
}
