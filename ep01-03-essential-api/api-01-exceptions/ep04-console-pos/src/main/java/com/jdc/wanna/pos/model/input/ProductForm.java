package com.jdc.wanna.pos.model.input;

import com.wanna.console.validator.annotation.MinValue;
import com.wanna.console.validator.annotation.NotBlank;

public record ProductForm(
		@NotBlank(message = "Please Enter product name.")
		String name,
		@MinValue(value = 100, message = "Please Enter price minmum of 100.")
		int price) {

}
