package com.wanna.console.validator;

import com.wanna.console.validator.provider.FieldValidatorForMaxLength;
import com.wanna.console.validator.provider.FieldValidatorForMaxValue;
import com.wanna.console.validator.provider.FieldValidatorForMinLength;
import com.wanna.console.validator.provider.FieldValidatorForMinValue;
import com.wanna.console.validator.provider.FieldValidatorForNotBlank;
import com.wanna.console.validator.provider.FieldValidatorForNotNull;
import com.wanna.console.validator.provider.OneStopValidator;

public interface Validator {

	
	ValidationResult validate(Object data);
	
	static Validator getInstance() {
		return new OneStopValidator(
			new FieldValidatorForMaxLength(),
			new FieldValidatorForMaxValue(),
			new FieldValidatorForMinLength(),
			new FieldValidatorForMinValue(),
			new FieldValidatorForNotBlank(),
			new FieldValidatorForNotNull()
 
		);
	}
}
