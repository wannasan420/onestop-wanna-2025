package com.jdc.wanna.pos.utils;

import com.jdc.wanna.pos.model.output.Sale;
import com.wanna.console.app.component.TableView;
import com.wanna.console.app.component.TableViewData;
import com.wanna.console.app.component.TableViewModelBase;
import com.wanna.console.app.component.TableViewData.ColumnAlignment;
import com.wanna.console.app.utils.FormatUtils;

public class SaleHistoryTableHelper {

	public static TableView getTableView(Sale[] sales) {
		var headers = new String[] {"Id", "Sale At", "Total Items","Total Amount"};
		var columns = new ColumnAlignment[] {ColumnAlignment.Left,ColumnAlignment.Left,ColumnAlignment.Right,ColumnAlignment.Right};
		String[][] contents = new String[sales.length][];
		
		for(var i = 0; i < contents.length; i++) {
			var item = sales[i];
			contents[i] = new String[headers.length];
			
			contents[i][0] = String.valueOf(item.id());
			contents[i][1] = item.saleAt().format(FormatUtils.DTTF);
			contents[i][2] = String.valueOf(item.getItemCount());
			contents[i][3] = FormatUtils.DF.format(item.getAllTotal());
		}
		
		var data =  new TableViewData(columns,headers,contents);
		 
		return new TableView(new TableViewModelBase(data));
	}
}
