package com.wanna.online.validator.domain;

import java.util.Date;

import com.wanna.console.validator.annotation.MaxLength;
import com.wanna.console.validator.annotation.MinLength;
import com.wanna.console.validator.annotation.NotBlank;
import com.wanna.console.validator.annotation.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

	@NotBlank
	private String name;

	@MinLength(6)
	@MaxLength(12)
	private String phone;

	@NotNull
	private Date dob;
	
}
