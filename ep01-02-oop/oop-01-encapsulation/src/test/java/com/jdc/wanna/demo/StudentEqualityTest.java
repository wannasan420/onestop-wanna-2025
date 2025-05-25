package com.jdc.wanna.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class StudentEqualityTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/students.txt")
	void test_add_student(int id, String name, String phone,String email) {
		
		var student1 = new Student(id,name,phone,email);
		var student2 = new Student(id,name,phone,email);
		
		//System.out.println(student1);
		//System.out.println(student2);
		
		assertEquals(student1, student2);
	}
}
