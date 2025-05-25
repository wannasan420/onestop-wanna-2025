package com.wanna.console.validator.provider;

import java.lang.reflect.Field;

import com.wanna.console.validator.FieldError;
import com.wanna.console.validator.annotation.MaxLength;

public class FieldValidatorForMaxLength extends AbstractFieldValidator {

	@Override
	public FieldError validate(Field field, Object object) {
		
		try { 
			var annotation = field.getDeclaredAnnotation(MaxLength.class);
			
			if(annotation != null && isStringType(field)) {
				
				field.setAccessible(true);
				var value = field.get(object);
				
				if(value != null && isViolate(value, annotation)) {
					 
					return new FieldError(field.getName(),annotation.message());
				} 
			}
			  
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	private boolean isViolate(Object data, MaxLength annotation) {
		if(data instanceof String str) {
			return str.length() > annotation.value();
		}
		
		
		return false;
	}

}
