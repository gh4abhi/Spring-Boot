package com.sbi.yono.beneficiaryms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.sbi.yono.*")
@EntityScan(basePackages = {"com.sbi.yono.*"})
@EnableJpaRepositories(basePackages = "com.sbi.yono.beneficiaryms.repository")
@SpringBootApplication
public class BeneficiarymsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiarymsApplication.class, args);
	}

}
