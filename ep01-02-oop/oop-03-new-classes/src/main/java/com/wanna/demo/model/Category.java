package com.wanna.demo.model;

import com.wanna.demo.metadata.NotBlank;

import lombok.Data;

@Data
@NotBlank(lee = 4,messages = "lee lar",value =10)
public class Category {

	private int id;
	private final String name;
}
