package com.sbi.yono.beneficiaryms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.yono.beneficiaryms.model.Payer;
import com.sbi.yono.beneficiaryms.service.AddPayeeSVC;

@RestController
public class AddPayee {
	
	@Autowired
	AddPayeeSVC addPayeeSVC;
	
	@RequestMapping("/Hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/getpayer/{id}")
	@Cacheable(key="#id",value="Payer")
	public Payer getPayerDtls(@PathVariable Integer id)
	{
		return addPayeeSVC.getPayer(id);
	}

}
