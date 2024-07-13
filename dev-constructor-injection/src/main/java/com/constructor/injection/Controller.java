package com.constructor.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	Coach coach;
	
	@Autowired
	public Controller(Coach newCoach)
	{
		this.coach = newCoach;
	}
	
	@GetMapping("/")
	public String getDailyWorkout()
	{
		return coach.getDailyWorkout();
	}
}
