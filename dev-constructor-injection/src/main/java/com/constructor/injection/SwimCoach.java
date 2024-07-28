package com.constructor.injection;

public class SwimCoach implements Coach{
	
	public void SwimCoach()
	{
		System.out.println(getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim for 20 mins";
	}
}
