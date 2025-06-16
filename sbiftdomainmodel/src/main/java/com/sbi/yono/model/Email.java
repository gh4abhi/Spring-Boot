package com.sbi.yono.model;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class Email {
	
	String recipient;
	String body;
	String subject;
	String cc[];
	@Value("$(spring.mail.username)")
	String fromMail;
}
