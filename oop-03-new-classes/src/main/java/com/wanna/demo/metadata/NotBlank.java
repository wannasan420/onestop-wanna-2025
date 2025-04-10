package com.wanna.demo.metadata;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ TYPE, FIELD })
public @interface NotBlank {

	String messages() default "Field must be added";
	
	int value();
	int lee();
}
