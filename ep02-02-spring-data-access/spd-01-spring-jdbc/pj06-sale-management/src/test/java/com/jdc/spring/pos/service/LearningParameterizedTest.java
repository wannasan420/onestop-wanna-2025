package com.jdc.spring.pos.service;

import java.time.DayOfWeek;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;

import com.jdc.spring.pos.domain.input.ShoppingCart;
import com.jdc.spring.pos.service.data.ShoppingCartProvider;

public class LearningParameterizedTest {
	
	@ParameterizedTest
	@EnumSource(
			value = DayOfWeek.class,
			names = {
				"SUNDAY","SATURDAY"
			},
			mode = Mode.EXCLUDE)
	void using_enum_source(DayOfWeek input) {
		System.out.println(input);
	}

	@ParameterizedTest
	@MethodSource
	void using_method_source(String input) {
		System.out.println(input);
	}
	
	@ParameterizedTest
	@MethodSource("com.jdc.spring.pos.service.data.ShoppingCartProvider#provide")
	void using_external_method_source(ShoppingCart cart) {
		System.out.println(cart);
	}
	
	@ParameterizedTest
	@ArgumentsSource(value = ShoppingCartProvider.class)
	void using_argument_source(ShoppingCart cart) {
		System.out.println(cart);
	}
	
	static Stream<String> using_method_source(){
		return Stream.iterate('A', a -> (char)(a.charValue() + 1))
				.limit(5)
				.map(a -> a.toString());
	}
	
	
	
}
