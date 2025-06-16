package com.sbi.yono.landingms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.sbi.yono.*")
@EntityScan(basePackages = {"com.sbi.yono.*"})
@EnableJpaRepositories(basePackages = "com.sbi.yono.landingms.repository")
@SpringBootApplication
public class LandingmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandingmsApplication.class, args);
	}

}
