package com.revise.injection.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBean {
	
	@Bean("Winter")
	public Season winter()
	{
		return new Winter();
	}
}
