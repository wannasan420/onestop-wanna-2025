package com.jdc.wanna.pos.model;

import java.util.Arrays;

import com.jdc.wanna.pos.model.input.ProductForm;
import com.jdc.wanna.pos.model.output.Product;

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
		
		
		return null;
	}

}
