package com.jdc.spring.trx.exception;

public class TransferException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TransferException(String message) {
		super(message);
	}

}