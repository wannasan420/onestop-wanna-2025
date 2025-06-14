package com.jdc.wanna.pos.model;

import java.util.Arrays;

import com.jdc.wanna.pos.model.input.ProductForm;
import com.jdc.wanna.pos.model.output.Product;
import com.wanna.console.app.exceptions.BusinessException;

public class ProductModelImpl extends AbstractModel implements ProductModel{

	private static ProductModel instance;
	private static int ID;
	
	private Product[] data = {};
	
	private ProductModelImpl() {};
	
	public static ProductModel getInstance() {
		if(instance == null) {
			instance = new ProductModelImpl();
		}
		return instance;
	}
	
	@Override
	public int create(ProductForm form) {
		
		validate(form);
		
		var product = new Product(++ID, form.name(), form.price());
		
		data = Arrays.copyOf(data, data.length+1);
		data[data.length - 1] = product;
		
		return ID;
	} 

	@Override
	public Product[] search(String name) {
		
		var result = new Product[] {};
		
		for(var product : data) {
			if(null == name || name.isBlank() 
					|| product.name().toLowerCase().startsWith(name.toLowerCase())) {
				
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = product;
			}
		}
		return result;
	}

	@Override
	public Product findById(int id) {
		
		for(var product : data) {
			if(product.id() == id) {
				return product;
			}
		}
	
		throw new BusinessException("Please enter valid product id.");
	}

}
