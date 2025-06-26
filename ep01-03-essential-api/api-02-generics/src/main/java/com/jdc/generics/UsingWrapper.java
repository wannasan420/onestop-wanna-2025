package com.jdc.generics;

public class UsingWrapper {

	public static void use (Wrapper<?> wrapper) {
		
	}
	public static void useNumber(NumberWrapper<?> wrapper) {
		
	}
	public static  Wrapper<?> getWrapper() {
		return null;
	}
	
	public static void main(String[] args) {
		use(new NumberWrapper<Number>());
		
		use(new NumberWrapper<Integer>());
		
		use(new IntegerWrapper());
		
		useNumber(new NumberWrapper<Number>());
		
		useNumber(new NumberWrapper<Integer>());
		
		Wrapper<?> wrapper2 = new IntegerWrapper();
		
		Wrapper<?> wrapper = new NumberWrapper<Number>();
	
		System.out.println(wrapper2.getData());
		wrapper = getWrapper();
		wrapper2 = getWrapper();
	}

}
