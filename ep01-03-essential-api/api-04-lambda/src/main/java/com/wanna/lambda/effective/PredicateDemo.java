package com.wanna.lambda.effective;

import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		
		var list = List.of(1,2,3,4,5,6,7,8,9);
		Predicate<Integer> greaterThanFour = data -> data > 4;
		Predicate<Integer> evenNumber = data -> data % 2 == 0;
		
		printIfTrue(list , greaterThanFour);
		System.out.println("----");
		printIfTrue(list, evenNumber);
		System.out.println("----");
		printIfTrue(list, evenNumber.negate().and(greaterThanFour.negate()));
	}
	
	public static void printIfTrue(List<Integer> list, Predicate<Integer> predicate) {
		
		list.forEach(data -> {
			if(predicate.test(data)) {
				System.out.println(data);
			}
		});
		
	}
}
