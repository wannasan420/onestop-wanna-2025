package com.wanna.console.validator.provider;

import java.lang.reflect.Field;

import com.wanna.console.validator.FieldError;
import com.wanna.console.validator.annotation.NotNull;

public class FieldValidatorForNotNull extends AbstractFieldValidator{

	@Override
	public FieldError validate(Field field, Object object) {
		try {
			var annotation = field.getDeclaredAnnotation(NotNull.class);
			
			if(annotation != null){
				
				field.setAccessible(true);
				
				if(field.get(object) == null) {
					
					return new FieldError(field.getName(),annotation.message());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
