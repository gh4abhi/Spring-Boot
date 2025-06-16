package com.sbi.yono.landingms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.yono.landingms.service.AddPayerSvc;
import com.sbi.yono.landingms.service.JavaEmailService;
import com.sbi.yono.model.Email;
import com.sbi.yono.model.Payer;

@RestController
@EnableCaching
public class AddPayer {
	
	@Autowired
	AddPayerSvc addpayersvc;
	
	@Autowired
	JavaEmailService emailsvc;
	
	
//	@Autowired
//	public AddPayer(AddPayerSvc addpayersvc) {
//		super();
//		this.addpayersvc = addpayersvc;
//	}
	
	@RequestMapping("/hello")
	public String Hello() {
		return "hello1";
	}
	
	

	@RequestMapping("/addpayer")
	@CachePut(key="#payer.pyrId",value="Payer")
	public Payer addPayer(@RequestBody Payer payer) {
		return addpayersvc.insertPayer(payer);
	
	}
	
	@RequestMapping("/getpayer")
	//@Cacheable(key="pyrDtls",value="Payer")
	public ArrayList<Payer> getAllPayer() {
		return addpayersvc.getAllPayer();
	
	}
	

	@RequestMapping("/getpayer/{id}")
	@Cacheable(key="#id",value="Payer")
	public Payer getPayerById(@PathVariable Integer id) {
		
		return addpayersvc.getPayer(id);
	
	}
	
	@RequestMapping("/sendmail")
	
	public String sendMail(@RequestBody Email email) {
		
		
		return emailsvc.sendMail(email.getRecipient(), email.getBody(), email.getSubject(),email.getCc(),email.getFromMail());
	
	}
}
