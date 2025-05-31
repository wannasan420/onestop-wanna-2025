package com.jdc.wanna.pos;

import com.jdc.wanna.pos.features.FeatureForAddProduct;
import com.jdc.wanna.pos.features.FeatureForAddSale;
import com.jdc.wanna.pos.features.FeatureForSaleDetails;
import com.jdc.wanna.pos.features.FeatureForSearchProduct;
import com.jdc.wanna.pos.features.FeatureForSearchSale;
import com.wanna.console.app.ConsoleApplication;

public class PosApplication {

	public static void main(String[] args) {
		
		var application = new ConsoleApplication("Console POS", 
				new FeatureForAddProduct(1),
				new FeatureForAddSale(2),
				new FeatureForSaleDetails(3),
				new FeatureForSearchProduct(4),
				new FeatureForSearchSale(5));
		
		application.launch();
	}
}
