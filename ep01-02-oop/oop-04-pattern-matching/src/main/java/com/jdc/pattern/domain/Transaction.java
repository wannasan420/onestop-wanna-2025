package com.jdc.pattern.domain;

public sealed interface Transaction permits AbstractTransaction{

	Long getTransactionId();
	String getTransactionName();
}
