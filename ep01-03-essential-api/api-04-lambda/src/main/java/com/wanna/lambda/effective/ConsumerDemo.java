package com.wanna.lambda.effective;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		
		Consumer<String> printSmall = str -> System.out.println(str.toLowerCase());
		Consumer<String> printBig = str -> System.out.println(str.toUpperCase());
		Consumer<String> printReversed = str -> System.out.println(
				new StringBuilder(str).reverse().toString()
				);
		
		Consumer<String> andThens = printSmall.andThen(printBig).andThen(printReversed);
		
		List.of("Java","Spring","Angular","Microservices")
			.forEach(andThens);
		
	}
}
