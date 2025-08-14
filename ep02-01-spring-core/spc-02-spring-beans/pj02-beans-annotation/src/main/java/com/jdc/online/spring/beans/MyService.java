package com.jdc.online.spring.beans;

import org.springframework.stereotype.Component;

@Component(value="service1")
public class MyService {

	public String message() {
		return "Hello from the annotation base bean";
	}
}
