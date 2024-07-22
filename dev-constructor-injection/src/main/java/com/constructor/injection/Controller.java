package com.constructor.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	Coach criceketCoach;
	Coach basketBallCoach;
	
	
	
	@Autowired
	public Controller(@Qualifier("Cricket") Coach coachc, Coach coachb)
	{
		this.criceketCoach = coachc;
		this.basketBallCoach = coachb;
		System.out.println(getClass().getSimpleName());
	}
	
	@GetMapping("/cricket")
	public String getDailyWorkoutCricket()
	{
		return criceketCoach.getDailyWorkout();
	}
	
	@GetMapping("/basketball")
	public String getDailyWorkoutBasketBall()
	{
		return basketBallCoach.getDailyWorkout();
	}
}
