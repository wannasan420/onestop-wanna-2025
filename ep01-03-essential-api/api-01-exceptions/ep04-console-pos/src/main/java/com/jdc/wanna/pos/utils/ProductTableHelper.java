package com.jdc.wanna.pos.utils;

import com.jdc.wanna.pos.model.output.Product;
import com.wanna.console.app.component.TableView;
import com.wanna.console.app.component.TableViewData;
import com.wanna.console.app.component.TableViewData.ColumnAlignment;
import com.wanna.console.app.component.TableViewModelBase;
import com.wanna.console.app.utils.FormatUtils;

public class ProductTableHelper {

	public static TableView getTableView(Product[] products) {
		
		var headers = new String[] {"Id", "Name", "Price"};
		var columns = new ColumnAlignment[] {ColumnAlignment.Left,ColumnAlignment.Left,ColumnAlignment.Right};
		String[][] contents = new String[products.length][];
		
		for(var i = 0; i < contents.length; i++) {
			var product = products[i];
			contents[i] = new String[headers.length];
			
			contents[i][0] = String.valueOf(product.id());
			contents[i][1] = product.name();
			contents[i][2] = FormatUtils.DF.format(product.price());
		}
		
		var data =  new TableViewData(columns,headers,contents);
		 
		return new TableView(new TableViewModelBase(data));
	}
}
