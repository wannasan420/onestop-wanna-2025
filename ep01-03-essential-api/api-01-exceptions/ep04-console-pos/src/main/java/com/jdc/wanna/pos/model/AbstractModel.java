package com.jdc.wanna.pos.model;

import com.wanna.console.app.exceptions.ValidationException;
import com.wanna.console.validator.Validator;

public abstract class AbstractModel {

	private static Validator validator;
	
	static {
		validator = Validator.getInstance();
	}
	
	protected void validate(Object data) {
		
		var result = validator.validate(data);
		
		if(result.hasErrors()) {
			
			var messages = new String[] {};
			
			for(int i = 0 ; i < messages.length ; i++) {
				messages[i] = result.getErrors()[i].getMessage();
			}
			throw new ValidationException(messages); 
		}
	}
}
