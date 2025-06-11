package com.wanna.console.app.component;

import com.wanna.console.app.exceptions.InvalidComponentDataException;
import com.wanna.console.app.utils.FormatUtils;

public record TableViewData(
		ColumnAlignment[] columns,
		String[] headers,
		String[][] contents 
		){
	
	public TableViewData{
		if(null == columns && columns.length == 0) {
			throw new InvalidComponentDataException("Table View", "Columns length cannot be empty");
		}
		
		if(null == headers && headers.length == 0) {
			throw new InvalidComponentDataException("Table View", "Headers length cannot be empty");
		}

		if(columns.length != headers.length ) {
			throw new InvalidComponentDataException("Table View", "Columns and Headers must have the same length");
		}
		for(var row : contents) {
			if(row == null && columns.length != row.length) {
				throw new InvalidComponentDataException("Table View", "Columns length and content data length must be same");
			}
		}
		
		 
	}

	public enum ColumnAlignment{
		Left {
			@Override
			public String format() {
				
				return FormatUtils.FMT_STRING;
			}
		}, Right {
			@Override
			public String format() {
				
				return FormatUtils.FMT_NUMBER;
			}
		};
		
		public abstract String format();
	}
}
