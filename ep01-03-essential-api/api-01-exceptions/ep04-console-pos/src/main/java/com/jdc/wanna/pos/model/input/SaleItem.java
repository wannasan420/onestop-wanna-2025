package com.jdc.wanna.pos.model.input;

import java.io.Serializable;

import com.jdc.wanna.pos.model.output.Product;
import com.wanna.console.validator.annotation.MinValue;
import com.wanna.console.validator.annotation.NotNull;

public record SaleItem(
		@NotNull(message = "Please enter product.")
		Product product,
		@MinValue(value = 1,message = "Please enter valid item count.")
		int count) implements Serializable{

	public int getTotal() {
		return product.price() * count;
	} 
}
 