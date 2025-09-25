package com.jdc.spring.pos.domain.output;

import lombok.Data;

@Data
public class SaleDetailsItem {

	private int id;
	private String productName;
	private String productCode;
	private int unitPrice;
	private int quantity;
	
	public int getIotal() {
		return unitPrice * quantity;
	}
}
