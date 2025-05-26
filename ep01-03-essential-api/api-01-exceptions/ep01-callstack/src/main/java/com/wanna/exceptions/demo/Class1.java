package com.wanna.exceptions.demo;

public class Class1 {

	private Class2 instance;
	
	public Class1() {
		instance = new Class2();
	}
	
	public int divide(int a, int b) {
			
			System.out.println("Class 2 Work");
			
			var value = instance.divide(a, b);
			
			System.out.println("Class 2 Work End");
			
			return value;
		}
	}
