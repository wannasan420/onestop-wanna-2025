package com.jdc.wanna.pos.features;

import com.jdc.wanna.pos.model.SaleModel;
import com.jdc.wanna.pos.utils.SaleHistoryTableHelper;
import com.wanna.console.app.AbstractFeature;
import com.wanna.console.app.UserInputs;

public class FeatureForSearchSale extends AbstractFeature {

	public FeatureForSearchSale(int id) {
		super(id, "Sale History");
	}
 
	@Override
	public void doBusiness() {
		
		var date = UserInputs.readString("Enter Date");
		
		
		var sales = SaleModel.getInstance().findByDate(date);
		
		SaleHistoryTableHelper.getTableView(sales).draw();
	}

}
