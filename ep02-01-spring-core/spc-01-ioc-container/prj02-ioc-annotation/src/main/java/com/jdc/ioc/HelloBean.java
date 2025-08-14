package com.jdc.ioc;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {

	public String sayHello() {
		return "Hello form annotation config string bean";
	}
}
