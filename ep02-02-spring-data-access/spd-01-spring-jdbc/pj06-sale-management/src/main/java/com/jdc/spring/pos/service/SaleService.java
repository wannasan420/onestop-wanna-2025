package com.jdc.spring.pos.service;

import java.time.LocalDate;
import java.util.List;

import com.jdc.spring.pos.domain.input.ShoppingCart;
import com.jdc.spring.pos.domain.output.SaleDetails;
import com.jdc.spring.pos.domain.output.SaleInfo;

public interface SaleService {

	int ChectOut(ShoppingCart cart);
	
	List<SaleInfo> search(String salePerson, LocalDate from, LocalDate to);
	
	SaleDetails findById();
}
