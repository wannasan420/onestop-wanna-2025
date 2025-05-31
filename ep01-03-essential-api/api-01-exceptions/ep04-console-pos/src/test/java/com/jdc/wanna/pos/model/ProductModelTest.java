package com.jdc.wanna.pos.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.wanna.pos.model.input.ProductForm;
import com.wanna.console.app.exceptions.ValidationException;

@TestMethodOrder(value = OrderAnnotation.class)
public class ProductModelTest {

	private static ProductModel model;
	
	@BeforeAll
	static void init() {
		model = ProductModelImpl.getInstance();
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		" ,500,Please Enter product name.,",
		"Coke,90,Please Enter price minmum of 100.,",
		",90,Please Enter product name.,Please Enter price minmum of 100."
		
	})
	void test_Product_add_error(String name, int price, String message1,String message2){
		
		var form = new ProductForm(name, price);
		
		var exception = assertThrows(ValidationException.class, ()->{
			model.create(form);
		});
		
		var messages = exception.getMessages();
		
		if(messages.length >= 1) {
			assertEquals(message1, messages[0]);
		}
		
		if(messages.length >= 2) {
			assertEquals(message2, messages[1]);
		}
		
		//exception.printStackTrace();
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"Coke,100,1",
		"Potato,100,2"
		
	})
	void test_product_success(String name, int price, int expectedId) {
		
		var form = new ProductForm(name, price);
		var id = model.create(form);
		
		
		assertEquals(expectedId, id);
	}
}
