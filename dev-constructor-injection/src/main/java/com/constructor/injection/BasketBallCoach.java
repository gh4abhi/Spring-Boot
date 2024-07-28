package com.constructor.injection;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BasketBallCoach  implements Coach{

	public BasketBallCoach()
	{
		System.out.println(getClass().getSimpleName());
	}
	
	@PostConstruct
	public void startup()
	{
		System.out.println("Start");
	}
	
	@PreDestroy
	public void end()
	{
		System.out.println("End");
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "Run 10 Laps of basketball ground.";
	}
}
