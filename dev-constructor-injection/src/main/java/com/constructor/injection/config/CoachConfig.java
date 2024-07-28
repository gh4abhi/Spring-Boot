package com.constructor.injection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.constructor.injection.Coach;
import com.constructor.injection.SwimCoach;

@Configuration
public class CoachConfig {
		
	@Bean("SwimCoach")
	public Coach getSwimCoach()
	{
		return new SwimCoach();
	}
	
}
