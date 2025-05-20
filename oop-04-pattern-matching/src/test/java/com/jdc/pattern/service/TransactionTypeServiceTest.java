package com.jdc.pattern.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.pattern.domain.TransactionTypeForCashOut;
import com.jdc.pattern.domain.TransactionTypeForTransfer;

public class TransactionTypeServiceTest {

	private TransactionTypeService service;
	
	@BeforeEach
	void initEach() {
		service = new TransactionTypeService();
	}
	
	@ParameterizedTest
	@CsvSource({
		"Cash Out,Thidar,196 Store"
	})
	void test_cashout(String name,String consumerName,String agentName) {
		var input = new TransactionTypeForCashOut(name, consumerName, agentName);
		service.show(input);
	}
	
	@ParameterizedTest
	@CsvSource({
		"Transfer,Thidar,Nilar"
	})
	void test_transfer(String name,String from,String to) {
		var input = new TransactionTypeForTransfer(name, from, to);
		service.show(input);
	}
	
}
