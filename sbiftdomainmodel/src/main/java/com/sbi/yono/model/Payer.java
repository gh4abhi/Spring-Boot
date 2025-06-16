package com.sbi.yono.model;

import java.io.Serializable;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
public class Payer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer pyrId;
	String pyrName;
	String pyrVpa;
	String ifsc;
	String bankName;

}
