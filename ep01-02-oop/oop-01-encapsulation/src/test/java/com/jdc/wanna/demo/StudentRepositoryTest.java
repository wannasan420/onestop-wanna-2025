package com.jdc.wanna.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
@TestMethodOrder(value = OrderAnnotation.class)
public class StudentRepositoryTest {

	static StudentRepository repo = new StudentRepository();

	@Order(1)
	@ParameterizedTest
	@CsvFileSource(resources = "/students.txt")
	void student_add_test(int id, String name, String phone, String email) {

		var input = new Student(name, phone, email);
		var output = repo.add(input);

		assertEquals(id, output);
	}

	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = 5)
	void test_find_All(int size) {
		
		var students = repo.getAll();
		assertEquals(students.length, size);
		
		Arrays.fill(students, null);
	}

	@Order(3)
	@ParameterizedTest
	@CsvFileSource(resources = "/students.txt")
	void test_find_by_Id(int id, String name, String phone, String email) {

		var student = repo.findById(id);
		assertEquals(name, student.getName());
		assertEquals(phone, student.getPhone());
		assertEquals(email, student.getEmail());
	}
}
