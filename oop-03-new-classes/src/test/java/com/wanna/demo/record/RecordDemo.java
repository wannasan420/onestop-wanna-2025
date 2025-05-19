package com.wanna.demo.record;

import org.junit.jupiter.api.Test;

import com.wanna.demo.record.Patient;
import com.wanna.demo.record.Student;
import com.wanna.demo.record.Patient.BloodType;
import com.wanna.demo.record.Patient.Gender;

public class RecordDemo {

	@Test
	void test_record() {
		
		var student = new Student(7, "Wanna", "0967611708");
		
		System.out.println(student);
	}
	
	@Test 
	void test_builder() {
		
		var patient = new Patient.Builder().id(2).name("Thiha").gender(Gender.Male).blood(BloodType.B).build();
		System.out.println(patient);
		
	}
}
