package com.jdc.wanna.pos.features;

import com.jdc.wanna.pos.model.ProductModel;
import com.wanna.console.app.AbstractFeature;
import com.wanna.console.app.UserInputs;

public class FeatureForAddSale extends AbstractFeature {

	public FeatureForAddSale(int id) {
		super(id, "Create Sale");
	}

	@Override
	public void doBusiness() {
		
		var name = UserInputs.readString("Name");
		
		var products = ProductModel.getInstance().search(name);
	}

}
