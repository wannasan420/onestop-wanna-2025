package com.jdc.basic.streams.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import com.jdc.streams.domain.Product;

public class GetMultipleResult {

	@Test
	void test_to_array() {
		try(var stream = Files.lines(Path.of("data","Product","product1.txt"))) {
			
			Object[] array = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.toArray();
				
			for (Object object : array) {
				System.out.println(object);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_to_generic_array() {
		
		try(var stream = Files.lines(Path.of("data","Product","product1.txt"))) {
			
			Product[] array = stream.map(line -> line.split("\t"))
				.map(Product::from)
				.toArray(value -> new Product[value]);
				
			for (Product product : array) {
				System.out.println(product);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
