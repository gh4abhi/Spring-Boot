package com.constructor.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	Coach criceketCoach;
	Coach basketBallCoach;
	Coach baskeballCaoch2;
	Coach SwimmingCoach;
	
	
	
	@Autowired
	public Controller(@Qualifier("Cricket") Coach coachc, Coach coachb, Coach coachb2, @Qualifier("SwimCoach") Coach coachs)
	{
		this.criceketCoach = coachc;
		this.basketBallCoach = coachb;
		this.baskeballCaoch2 = coachb2;
		this.SwimmingCoach = coachs;
		System.out.println(getClass().getSimpleName());  
	}
	
	@GetMapping("/scope")
	public boolean checkScope()
	{
		return basketBallCoach==baskeballCaoch2;
	}
	
	@GetMapping("/cricket")
	public String getDailyWorkoutCricket()
	{
		return criceketCoach.getDailyWorkout();
	}
	
	@GetMapping("/basketball")
	public String getDailyWorkoutSwiming()
	{
		return basketBallCoach.getDailyWorkout();
	}
	
	@GetMapping("/swimming")
	public String getDailyWorkoutBasketBall()
	{
		return SwimmingCoach.getDailyWorkout();
	}
	
}
