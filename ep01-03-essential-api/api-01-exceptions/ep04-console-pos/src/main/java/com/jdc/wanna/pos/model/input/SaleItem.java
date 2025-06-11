package com.jdc.wanna.pos.model.input;

import com.jdc.wanna.pos.model.output.Product;
import com.wanna.console.validator.annotation.MinValue;
import com.wanna.console.validator.annotation.NotNull;

public record SaleItem(
		@NotNull(message = "Please enter product.")
		Product product,
		@MinValue(value = 1,message = "Please enter item count.")
		int count) {

	public int getTotal() {
		return product.price() * count;
	}
}
 