package com.jdc.pattern.service;

import com.jdc.pattern.domain.TransactionType;
import com.jdc.pattern.domain.TransactionTypeForCashOut;
import com.jdc.pattern.domain.TransactionTypeForTransfer;

public class TransactionTypeService {

	public void show(TransactionType type) {
		
		System.out.println("Transaction Record Information");
		
		System.out.printf("%-16s : %s%n","Type name",type.name());
		
		if(type instanceof TransactionTypeForCashOut(var name,var consumer,var agent)) {
			System.out.printf("%-16s : %s%n","Agent Name",agent);
			System.out.printf("%-16s : %s%n","Consumer Name",consumer);
			System.out.println();
			
		}
		if(type instanceof TransactionTypeForTransfer(var name,var from,var to)) {
			System.out.printf("%-16s : %s%n","From",from);
			System.out.printf("%-16s : %s%n","To",to);
			System.out.println();
		}
		
	
	}
}
