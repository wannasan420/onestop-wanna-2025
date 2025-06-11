package com.jdc.wanna.pos.features;

import com.jdc.wanna.pos.model.ProductModel;
import com.jdc.wanna.pos.utils.ProductTableHelper;
import com.wanna.console.app.AbstractFeature;
import com.wanna.console.app.UserInputs;

public class FeatureForSearchProduct extends AbstractFeature{

	public FeatureForSearchProduct(int id) {
		super(id, "Search Product");
		
	}

	@Override
	public void doBusiness() {
		
		var name = UserInputs.readString("Name");
		
		var products = ProductModel.getInstance().search(name);
		
		var table = ProductTableHelper.getTableView(products);
		
		table.draw();
	}
 
	

}
