package com.jdc.wanna.pos.model;

import com.jdc.wanna.pos.model.input.ProductForm;
import com.jdc.wanna.pos.model.output.Product;

public interface ProductModel {
	
	static ProductModel getInstance() {
		return ProductModelImpl.getInstance();
	}

	int create(ProductForm form);

	Product[] search(String name);
}
