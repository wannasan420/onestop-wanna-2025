package com.wanna.console.validator;

import java.lang.reflect.Field;

public interface FieldValidator {

	FieldError validate(Field field,Object object); 
}
