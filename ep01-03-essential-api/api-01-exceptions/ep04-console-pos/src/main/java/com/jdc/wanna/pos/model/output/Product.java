package com.jdc.wanna.pos.model.output;

import java.io.Serializable;

public record Product(
		int id,
		String name,
		int price) implements Serializable{ 

}
