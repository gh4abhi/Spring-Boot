package com.sbi.yono.landingms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbi.yono.landingms.model.Payer;

@Repository
public interface InsertPayerRepo  extends JpaRepository<Payer, Integer>{
	

}
