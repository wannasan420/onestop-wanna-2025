package com.wanna.console.app.component;

public class TableView implements Drawable{

	private TableViewModel model;
	
	
	public TableView(TableViewModel model) {
		super();
		this.model = model;
	}


	@Override
	public void draw() {
		
		drawLine(model.MaxSize());
		System.out.println(model.Header());
		drawLine(model.MaxSize());
		
		for(var data : model.rows()) {
			
			System.out.println(data);
		}
		drawLine(model.MaxSize());
	}

	
	
	

}
