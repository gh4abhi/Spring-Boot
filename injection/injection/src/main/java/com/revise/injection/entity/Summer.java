package com.revise.injection.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class Summer implements Season{
	
	public Summer() {
		System.out.println(getClass().getName());
	}

	@Override
	public String getSeason()
	{
		return "Summer";
	}
	
}
