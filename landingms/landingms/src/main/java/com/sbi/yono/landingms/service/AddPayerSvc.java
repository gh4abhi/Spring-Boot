package com.sbi.yono.landingms.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.sbi.yono.landingms.repository.InsertPayerRepo;
import com.sbi.yono.model.Payer;
@Service
public class AddPayerSvc {

	private static final String HASH_KEY = "Payer";
	@Autowired
	InsertPayerRepo insertPayerRepo;

	@Qualifier("redisTemplate")
	@Autowired
	RedisTemplate template;

	public Payer insertPayer(Payer payer) {
		try {
			// store data in database

			insertPayerRepo.save(payer);
			// store data in cache
//			template.opsForHash().put("Payer", payer.getPyrId(), payer);
		} catch (Exception e) {
			return null;

		}

		return payer;

	}
    
	
	public ArrayList<Payer> getAllPayer() {

		try {
			System.out.println("Database function called");
			return (ArrayList<Payer>) insertPayerRepo.findAll();
		} catch (Exception e) {
			return new ArrayList<Payer>();

		}

	}
	
	public Payer getPayer(Integer id) {
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
