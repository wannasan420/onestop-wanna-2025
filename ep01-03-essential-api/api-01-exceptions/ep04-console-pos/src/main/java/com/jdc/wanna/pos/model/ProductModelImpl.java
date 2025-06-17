package com.jdc.wanna.pos.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import com.jdc.wanna.pos.model.input.ProductForm;
import com.jdc.wanna.pos.model.output.Product;
import com.jdc.wanna.pos.model.storage.ProductStorage;
import com.wanna.console.app.exceptions.BusinessException;

public class ProductModelImpl extends AbstractModel implements ProductModel{

	private static final String FILE_NAME = "products.obj";
	private static ProductModel instance;
	private static int ID;
	
	private Product[] data = {};
	
	private ProductModelImpl() {
		try(var input = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			var result = input.readObject();
			if(result != null && result instanceof ProductStorage(var id, var data)) {
				ID = id;
				this.data = data;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	};
	
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
		
		try(var output = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			output.writeObject(new ProductStorage(ID, data));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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
