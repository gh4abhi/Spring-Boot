package com.spring.dev.project.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectRestController {
	
	@Value("${developer.name}")
	private String developerName;
	
	@GetMapping("/root")
	public String sayName()
	{
		return developerName;
	}
}
