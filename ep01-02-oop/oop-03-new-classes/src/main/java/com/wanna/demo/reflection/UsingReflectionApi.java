package com.wanna.demo.reflection;

import java.lang.reflect.InvocationTargetException;

public class UsingReflectionApi {

	public Product getProduct() {
		
		try {
			return Product.class.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			
			throw new RuntimeException();
		}
	}
	
	public void showMethod(Product product) {
		
		var methods = product.getClass().getMethods();
		
		for(var method : methods) {
			System.out.println(method.getName());
		}
	}
	
	public void showFields(Product product) {
		
		var fields = product.getClass().getDeclaredFields();
		
		for(var field : fields) {
			System.out.println(field.getName());
		}
	}
	
	public void setFeilds(Product product, int id, String name, int price) {
		
		var fields = product.getClass().getDeclaredFields();
		
		for(var field : fields) {
			try {
				field.setAccessible(true);
				
				switch(field.getName()) {
				case"id"-> field.set(product, id);
				case"name" -> field.set(product,id);
				case"price" -> field.set(product, price);
				}
			} catch (Exception e) {
				throw new RuntimeException();
			}
			
		}
	}
}
