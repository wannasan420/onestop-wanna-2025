package com.wanna.console.validator.provider;

import java.lang.reflect.Field;
import java.util.Arrays;

import com.wanna.console.validator.FieldError;
import com.wanna.console.validator.FieldValidator;
import com.wanna.console.validator.ValidationResult;
import com.wanna.console.validator.Validator;

public class OneStopValidator implements Validator {

	private FieldValidator[] validators;

	public OneStopValidator(FieldValidator ... validators) {
		super();
		this.validators = validators;
	}


	@Override
	public ValidationResult validate(Object data) {
		
		FieldError[] errors = {};
		
		Field[] fields = data.getClass().getDeclaredFields();
		
		for(Field field : fields) {
			for(FieldValidator validator : validators) { 
				
				FieldError error = validator.validate(field, data);
				
				if(null != error) {
					
					errors =  Arrays.copyOf(errors, errors.length + 1);
					errors[errors.length - 1] = error;
				}
			}
		}
		return new ValidationResult(errors);
	}

}
