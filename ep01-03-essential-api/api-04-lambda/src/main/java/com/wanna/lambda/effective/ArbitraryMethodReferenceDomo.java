package com.wanna.lambda.effective;

import java.util.function.BiFunction;

public class ArbitraryMethodReferenceDomo {

	public static String merge(
			String first,
			String second,
			BiFunction<String, String, String> merger) {
		return merger.apply(first, second);
	}
	
	public static void main(String[] args) {
		var result = merge("First","Second",String::concat);
		System.out.println(result);
	}
}
