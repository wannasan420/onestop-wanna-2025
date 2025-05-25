package com.wanna.online.validator.domain;

import com.wanna.console.validator.annotation.MaxValue;
import com.wanna.console.validator.annotation.MinValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Numbers {

	@MinValue(value=10)
	@MaxValue(value=100)
	private byte byteValue;
	
	@MinValue(value=10)
	@MaxValue(value=100)
	private short shortValue;       
	
	@MinValue(value=10)
	@MaxValue(value=100)
	private int intValue;
	
	@MinValue(value=10)
	@MaxValue(value=100)
	private long longValue;
	
}
