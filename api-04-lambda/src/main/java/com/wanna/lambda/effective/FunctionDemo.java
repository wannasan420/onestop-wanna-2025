package com.wanna.lambda.effective;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionDemo {

	public static void main(String[] args) {
		
		Function<Integer,String> countA = count -> {
			var sb = new StringBuffer(); 
			for(var i = 0; i < count; i++) {
				sb.append("A");
			}
			return sb.toString();
		};
		
		Function<Integer,String> twiceAndString = count ->{
			var twice = count * 2;
			return String.valueOf(twice);
		};
		
		UnaryOperator<String> toLowerCase = str -> str.toLowerCase(); 
		
		var result = convert(List.of(1,2,3,4,5), countA);
		result.forEach(data -> System.out.println(data));
		System.out.println("------------");
		
		result = convert(List.of(1, 2, 3, 4, 5), twiceAndString);
		result.forEach(System.out::println);
		System.out.println("------------");
		
		result = convert(List.of(1, 2, 3, 4, 5), countA.andThen(toLowerCase));
		result.forEach(System.out::println);
		
	}
	
	public static List<String> convert(List<Integer> list, Function<Integer,String> func){
		
		var result = new ArrayList<String>();
		
		for(var item : list) {
			result.add(func.apply(item));
		}
		return result;
	}
}
