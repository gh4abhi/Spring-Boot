package com.sbi.yono.beneficiaryms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.yono.beneficiaryms.model.Payer;
import com.sbi.yono.beneficiaryms.repository.InsertPayerRepo;

@Service
public class AddPayeeSVC {
	
	@Autowired
	InsertPayerRepo insertPayerRepo;
	
	public Payer getPayer(Integer id)
	{
		try {
			System.out.println("Database function called");
			Optional<Payer> pyr = insertPayerRepo.findById(id);
			
			//fetch data from cache
			//template.opsForHash().get("Payer", id);
			return pyr.get();
		} catch (Exception e) {
			return new Payer();
		}
	}
	
}
