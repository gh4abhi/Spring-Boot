package com.constructor.injection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component("Cricket")
public class CricketCoach implements Coach{
	
	public CricketCoach()
	{
		System.out.println(getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "Practice batting for 15 mins.";
				
	}
}
