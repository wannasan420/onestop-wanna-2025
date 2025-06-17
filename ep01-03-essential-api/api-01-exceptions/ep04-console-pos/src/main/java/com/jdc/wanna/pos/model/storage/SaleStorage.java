package com.jdc.wanna.pos.model.storage;

import java.io.Serializable;

import com.jdc.wanna.pos.model.output.Sale;

public record SaleStorage(
		int lastId,
		Sale[] sales) implements Serializable{

}
