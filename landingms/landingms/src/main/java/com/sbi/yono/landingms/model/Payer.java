package com.sbi.yono.landingms.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

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
