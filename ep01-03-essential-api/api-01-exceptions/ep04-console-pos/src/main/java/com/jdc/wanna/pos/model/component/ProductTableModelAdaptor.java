package com.jdc.wanna.pos.model.component;

import java.text.DecimalFormat;

import com.jdc.wanna.pos.model.output.Product;
import com.wanna.console.app.component.TableViewModel;

public class ProductTableModelAdaptor implements TableViewModel{

	private Product[] products;
	
	private static final String HEADER_ID = "Id";
	private static final String HEADER_NAME = "Name";
	private static final String HEADER_PRICE ="Price";
	
	private int idLength = HEADER_ID.length() + 2;
	private int nameLength = HEADER_NAME.length() + 2;
	private int priceLength = HEADER_PRICE.length() + 2;
	
	private static final DecimalFormat DF = new DecimalFormat("#,##0.00");
	
	public ProductTableModelAdaptor(Product[] products) {
		super();
		this.products = products;
		
		for(var product : products) {
			
			if(String.valueOf(product.id()).length() +2 > idLength) {
				idLength = String.valueOf(product.id()).length() +2;
			}
			if(product.name().length() + 2 > nameLength) {
				nameLength = product.name().length() + 2;
			}
			if(DF.format(product.price()).length() + 2 > priceLength) {
				priceLength = DF.format(product.price()).length() + 2;
			}
		}
	}

	@Override
	public int MaxSize() {
		
		return idLength+nameLength+priceLength;
	}

	@Override
	public String Header() {
		
		return rowFormat().formatted(HEADER_ID,HEADER_NAME,HEADER_PRICE);
	}

	@Override
	public String[] rows() {
		
		var rows = new String[products.length];
		
		for(var i = 0; i < products.length; i++) {
			var product = products[i];
			rows[i] = rowFormat().formatted(product.id(),product.name(),product.price());
		}
		return rows;
	}
	
	private String rowFormat() {
		var fmt = "%%-%ds%%-%ds%%%ds";
		return fmt.formatted(idLength,nameLength,priceLength);
	}

}
