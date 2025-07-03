package com.jdc.basic.streams.creation;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class CreateFormIteration {

	@Test
	void test_iterate_stream() {
		
		System.out.println("Test with limit");
		var stream = IntStream.iterate(1, a -> a + 1);
		var result = stream.mapToObj(a -> String.valueOf(a)).limit(10).collect(Collectors.joining(","));
		System.out.println(result);
		
		System.out.println("Test with predicate");
		var stream2 = IntStream.iterate(1, a -> a <=10, a -> a +1);
		var result2 = stream2.mapToObj(a -> String.valueOf(a)).collect(Collectors.joining(","));
		System.out.println(result2);
		
		System.out.println("test generics iteration");
		var stream3 = Stream.iterate(".", a -> a.length() <= 10, a -> a + ".");
		stream3.forEach(a -> System.out.println(a));
	}
}
