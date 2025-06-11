package com.wanna.console.app.component;

import java.util.Arrays;

import com.wanna.console.app.exceptions.InvalidComponentDataException;

public class TableViewModelBase implements TableViewModel{

	private TableViewData data;
	private int[] columnSizes;
	private String rowFormat;
	
	public TableViewModelBase(TableViewData data) {
		
		this.data = data;
		if(data == null) {
			throw new InvalidComponentDataException("Table View", "Data for table view cannot be null.");
		}
		
		initColumnSizes();
		
		initRowFormat();
	}
	
	private void initRowFormat() {
		
		var sb = new StringBuilder();
		
		for( var i = 0; i < columnSizes.length; i++) {
			
			var allignment = data.columns()[i];
			var maxSize = columnSizes[i];
			
			sb.append(allignment.format().formatted(maxSize));
		}
		rowFormat = sb.toString();
	}

	private void initColumnSizes() {
		columnSizes = new int[data.columns().length] ;
		
		for(var i = 0; i < columnSizes.length; i++) {
			
			var maxLength = data.headers()[i].length();
			
			for(var content : data.contents()) {
				
				maxLength = maxLength > content[i].length() ? maxLength: content[i].length();
			}
			columnSizes[i] = maxLength + 3;
		}
		
	}

	@Override
	public String Header() {
		
		return rowFormat.formatted(Arrays.asList(data.headers()).toArray());
	}
	
	@Override
	public int MaxSize() {
		var total = 0;
		for(var size : columnSizes) {
			total += size;
		}
		return total; 
	}
	
	@Override
	public String[] rows() {
		
		var array = new String[data.contents().length];
		for(var i = 0; i < array.length; i++) {
			var rowData = data.contents()[i];
			array[i] = rowFormat.formatted(Arrays.asList(rowData).toArray());
		}
		return array;
	}
}
