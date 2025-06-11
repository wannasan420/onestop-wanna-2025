package com.jdc.wanna.pos.utils;

import com.jdc.wanna.pos.model.input.SaleItem;
import com.wanna.console.app.component.TableView;
import com.wanna.console.app.component.TableViewData;
import com.wanna.console.app.component.TableViewModelBase;
import com.wanna.console.app.component.TableViewData.ColumnAlignment;
import com.wanna.console.app.utils.FormatUtils;

public class SaleItemTableHelper {

	public static TableView getTableView(SaleItem[] sales) {
		
		var headers = new String[] {"No", "Product","Unit Price","Qty","Total"};
		var columns = new ColumnAlignment[] {ColumnAlignment.Left,ColumnAlignment.Left,ColumnAlignment.Right,ColumnAlignment.Right,ColumnAlignment.Right};
		String[][] contents = new String[sales.length][];
		
		for(var i = 0; i < sales.length; i++) {
			var item = sales[i];
			contents[i] = new String[headers.length];
			
			contents[i][0] = String.valueOf(i+1);
			contents[i][1] = item.product().name();
			contents[i][2] = FormatUtils.DF.format(item.product().price());
			contents[i][3] = String.valueOf(item.count());
			contents[i][4] = FormatUtils.DF.format(item.getTotal());
		}
		
		var data =  new TableViewData(columns,headers,contents);
		 
		return new TableView(new TableViewModelBase(data));
	}
}
