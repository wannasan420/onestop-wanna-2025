package com.jdc.spring.pos.domain.output;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class SaleDetails {

	private int id;
	private String salePerson;
	private LocalDateTime saleAt;
	private List<SaleDetailsItem> items;
	
	public int getTotal() {
		if(null != items && !items.isEmpty()) {
			
		}
		return 0;
	}
}
