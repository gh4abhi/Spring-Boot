package com.sbi.yono.model;

import lombok.Data;

@Data
public class PymntInfo {
	
	private String ts;
	private String chnlRfId;
	private String pymntMode;
	private Payee payee;
	private  Payer payer;
	private String amount;
	
	
	
	   

}
