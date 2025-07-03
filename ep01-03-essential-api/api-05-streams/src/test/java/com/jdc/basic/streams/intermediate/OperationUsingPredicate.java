package com.jdc.basic.streams.intermediate;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class OperationUsingPredicate {

	@Test
	void test_take_while() {
		
		System.out.println("Take While");
		var stream = IntStream.iterate(1, a->a+1)
				.takeWhile(a -> a <= 10)
				.mapToObj(a -> String.valueOf(a))
				.collect(Collectors.joining(","));
		System.out.println(stream);
	}
	
	@Test
	void test_drop_while() {
		System.out.println("Drop While");
		var stream = IntStream.iterate(1, a -> a+1)
				.dropWhile(a -> a <=5)
				.limit(10)
				.mapToObj(a -> String.valueOf(a))
				.collect(Collectors.joining(","));
		
		System.out.println(stream);
	}
	
	@Test
	void test_filter() {
		
		System.out.println("Filter");
		var stream = IntStream.iterate(1, a -> a+1)
				.filter(a -> a%2 != 0)
				.skip(4)
				.limit(10)
				.mapToObj(a -> String.valueOf(a))
				.collect(Collectors.joining(","));
		
		System.out.println(stream);
	}
}
