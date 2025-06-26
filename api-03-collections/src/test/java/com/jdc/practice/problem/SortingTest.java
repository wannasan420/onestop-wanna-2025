package com.jdc.practice.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class SortingTest {

	@ParameterizedTest
	@MethodSource("sort_asc_int_array_data")
	void sort_asc_int_array(int[] input, int[] result) {
		
		Arrays.sort(input);
		Arrays.equals(input, result);
		
	}
	static Stream<Arguments> sort_asc_int_array_data(){
		return Stream.of(
				Arguments.of(
						new int[] {5, 7, 4, 3, 9, 1},
						new int[] {1, 3, 4, 5, 7, 9})
				);
	}
	
	@ParameterizedTest
	@MethodSource("sort_asc_int_list_data")
	void sort_asc_int_list(List<Integer> input, List<Integer> result) {
		Collections.sort(input);
		assertEquals(input, result);
	}
	static Stream<Arguments> sort_asc_int_list_data(){
		var input = List.of(5, 7, 4, 3, 9, 1);
		var result = List.of(1, 3, 4, 5, 7, 9);
		
		return Stream.of(
				Arguments.of(
						new ArrayList<Integer>(input),
						new ArrayList<Integer>(result)
						)
				); 
	}
	
	@ParameterizedTest
	@MethodSource("sort_asc_comparable_list_data")
	void sort_asc_comparable_list(List<ComparableValue> input, List<ComparableValue> result) {
		Collections.sort(input);
		var searchResult = Collections.binarySearch(input, new ComparableValue(10,"Ten"));
		System.out.println(searchResult);
		
		System.out.println(input);
	}
	static Stream<Arguments> sort_asc_comparable_list_data(){
		var input = List.of(new ComparableValue(10,null), new ComparableValue(7,"Seven"), new ComparableValue(10,"Ten"), new ComparableValue(5,"Five"), new ComparableValue(3,"Three"));
		var result = List.of(new ComparableValue(3,"Three"), new ComparableValue(5,"Five"), new ComparableValue(7,"Seven"), new ComparableValue(10,null), new ComparableValue(10,"Ten"));
		return Stream.of(
				Arguments.of(
						new ArrayList<ComparableValue>(input),
						new ArrayList<ComparableValue>(result))
				);
	}
	
	@ParameterizedTest
	@MethodSource("sort_by_comparator_data")
	void sort_by_comparator(List<Value> input) {
		
		Comparator<Value> comparator = new Comparator<Value> () {

			@Override
			public int compare(Value o1, Value o2) {
				
				return o1.data() - o2.data();
			}
			
		};
		Collections.sort(input,comparator);
		System.out.println(input);
	}
	static Stream<Arguments> sort_by_comparator_data() {
		var input = List.of(new Value(9), new Value(7), new Value(10), new Value(10), new Value(3));
		return Stream.of(Arguments.of(
			new ArrayList<>(input)
		));
	}
}
