package com.wanna.console.validator.provider;

import java.lang.reflect.Field;

import com.wanna.console.validator.FieldError;
import com.wanna.console.validator.annotation.MinValue;

public class FieldValidatorForMinValue extends AbstractFieldValidator {

	@Override
	public FieldError validate(Field field, Object object) {
		try {
			var annotation = field.getDeclaredAnnotation(MinValue.class);
			
			if(annotation != null && isNumberType(field)) {
				
				field.setAccessible(true);
				var value = field.get(object);
				
				if(value != null && isViolate(value, annotation)) {
					
					return new FieldError(field.getName(),annotation.message());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean isViolate(Object value, MinValue annotation) {
		
		if(value instanceof Long longValue) {
			
			return longValue < annotation.value();
		}
		
		return true;
	}
	

}
