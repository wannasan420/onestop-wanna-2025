package com.jdc.wanna.pos.features;

import com.jdc.wanna.pos.model.ProductModel;
import com.jdc.wanna.pos.model.component.ProductTableModelAdaptor;
import com.jdc.wanna.pos.model.output.Product;
import com.wanna.console.app.AbstractFeature;
import com.wanna.console.app.UserInputs;
import com.wanna.console.app.component.TableView;

public class FeatureForSearchProduct extends AbstractFeature{

	public FeatureForSearchProduct(int id) {
		super(id, "Search Product");
		
	}

	@Override
	public void doBusiness() {
		
		var name = UserInputs.readString("Name");
		
		var products = ProductModel.getInstance().search(name);
		
		var adaptor = new ProductTableModelAdaptor(products);
		var table = new TableView(adaptor);
		table.draw();
	}

}
