package com.wanna.console.validator.provider;

import java.lang.reflect.Field;

import com.wanna.console.validator.FieldValidator;

public abstract class AbstractFieldValidator implements FieldValidator {

	protected boolean isNumberType(Field field) {
		
		return field.getType() == byte.class 
				|| field.getType() == short.class
				|| field.getType() == int.class
				|| field.getType() == long.class;
				
	}
	
	protected boolean isStringType(Field field) {
		
		return field.getType() == String.class;
	}
}
