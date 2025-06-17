package com.jdc.wanna.pos.model.storage;

import java.io.Serializable;

import com.jdc.wanna.pos.model.output.Product;

public record ProductStorage(
		int lastId,
		Product[] products) implements Serializable{

}
