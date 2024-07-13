package com.constructor.injection;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
	@Override
	public String getDailyWorkout()
	{
		return "Practice batting for 15 mins.";
				
	}
}
