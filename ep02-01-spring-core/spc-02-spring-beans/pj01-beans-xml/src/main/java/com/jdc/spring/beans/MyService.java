package com.jdc.spring.beans;

public class MyService {

	public String name;
	
	public MyService(String name) {
		super();
		this.name = name;
	}

	public String message() {
		return name;
	}
}
