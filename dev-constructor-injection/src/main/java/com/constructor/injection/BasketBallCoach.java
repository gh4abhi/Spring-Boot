package com.constructor.injection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BasketBallCoach  implements Coach{

	@Override
	public String getDailyWorkout()
	{
		return "Run 10 Laps of basketball ground.";
	}
}
