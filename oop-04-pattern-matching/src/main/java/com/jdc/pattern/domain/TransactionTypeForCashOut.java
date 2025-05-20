package com.jdc.pattern.domain;

public record TransactionTypeForCashOut(
		String name,
		String consumername,
		String agentShop) implements TransactionType{

	

}
