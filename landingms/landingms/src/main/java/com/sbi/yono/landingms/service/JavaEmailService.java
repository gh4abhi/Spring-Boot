package com.sbi.yono.landingms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class JavaEmailService {
	
	@Autowired
	JavaMailSender  javamailsender;
	
//	@Value("$(info.user.name)")
	String username="Akku";
	
	public  String sendMail( String recipient, String body,String subject, String cc[],String fromMail) {
		SimpleMailMessage sm=new SimpleMailMessage();
		sm.setTo(recipient);
		sm.setFrom(username+" <"+fromMail+">");
		sm.setText(body);
		sm.setSubject(subject);
		sm.setCc(cc);
		try {
		javamailsender.send(sm);
		}
		catch (Exception e) {
			return "Email not sent";
		}
		return "Email Sent Successfully";
	}

}
