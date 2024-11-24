package com.sbi.yono.beneficiaryms.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
//@RedisHash("Payer")
public class Payer  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer pyrId;
	String pyrName;
	String pyrVpa;
	String ifsc;
    String bankName;

}
