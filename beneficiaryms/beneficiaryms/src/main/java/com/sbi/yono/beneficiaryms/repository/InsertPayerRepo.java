package com.sbi.yono.beneficiaryms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbi.yono.beneficiaryms.model.Payer;


@Repository
public interface InsertPayerRepo  extends JpaRepository<Payer, Integer>{
	

}