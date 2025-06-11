package com.jdc.wanna.pos.features;

import com.jdc.wanna.pos.model.SaleModel;
import com.jdc.wanna.pos.utils.SaleItemTableHelper;
import com.wanna.console.app.AbstractFeature;
import com.wanna.console.app.UserInputs;
import com.wanna.console.app.utils.FormatUtils;

public class FeatureForSaleDetails extends AbstractFeature {

	private static final int SIZE = 14;

	public FeatureForSaleDetails(int id) {
		super(id, "Sale Details");		
	}
 
	@Override
	public void doBusiness() {
		
		var id = UserInputs.readInt(SIZE,"Enter Sale ID");
		var sale = SaleModel.getInstance().findById(id);
		
		System.out.printf("%-14s : %s%n","Sale At",sale.saleAt().format(FormatUtils.DTTF));
		
		System.out.printf("%-14s : %s%n","Items",sale.getItemCount());
		
		System.out.printf("%-14s : %s%n","Total Amount",FormatUtils.DF.format(sale.getAllTotal()));
		
		System.out.println("Sale Items");
		
		SaleItemTableHelper.getTableView(sale.items()).draw();
	}

}
