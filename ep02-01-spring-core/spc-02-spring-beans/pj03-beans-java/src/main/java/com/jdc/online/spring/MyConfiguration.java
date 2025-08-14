package com.jdc.online.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.online.spring.beans.MyService;

@Configuration
public class MyConfiguration {

	@Bean
	MyService service() {
		return new MyService();
	}
}
