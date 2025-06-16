package com.revise.injection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revise.injection.entity.Season;

@RestController
public class ProjectRestController {
	
	Season summer, autumn, winter;
	
	@Autowired
	public ProjectRestController(Season summer, @Qualifier("Autumn") Season autumn, @Qualifier("Winter") Season winter)
	{
		this.summer = summer;
		this.autumn = autumn;
		this.winter = winter;
		System.out.println(getClass().getName());
	}
	
	@GetMapping("/")
	public String welcomScreen()
	{
		return "Welcome";
	}
	
	@GetMapping("/autumn")
	public String Autumn()
	{
		return autumn.getSeason();
	}
	
	@GetMapping("/summer")
	public String Summer()
	{
		return summer.getSeason();
	}
	
	@GetMapping("/winter")
	public String Winter()
	{
		return winter.getSeason();
	}
	
	
	
}
