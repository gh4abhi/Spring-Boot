package com.revise.injection.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component("Autumn")
public class Autumn implements Season{
	
	public Autumn() {
		System.out.println(getClass().getName());
	}

	@Override
	public String getSeason()
	{
		return "Autumn";
	}
	
}
