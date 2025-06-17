package com.jdc.wanna.pos.features;

import com.jdc.wanna.pos.model.ProductModel;
import com.jdc.wanna.pos.model.input.ProductForm;
import com.wanna.console.app.AbstractFeature;
import com.wanna.console.app.UserInputs;
import com.wanna.console.app.exceptions.ConsoleAppException;
import com.wanna.console.app.exceptions.ValidationException;

public class FeatureForAddProduct extends AbstractFeature{

	private static final int SIZE = 6;

	public FeatureForAddProduct(int id) {
		super(id, "Create Product ");
		// TODO Auto-generated constructor stub
	}

	@Override 
	public void doBusiness() {
		
		try {
			var name = UserInputs.readString(SIZE, "Name");
			
			var price = UserInputs.readInt(SIZE, "Price");
			
			var form = new ProductForm(name, price); 
			
			var id = ProductModel.getInstance().create(form);
			
			System.out.printf("%s has been created with id %d.%n",name,id);
			
		} catch (ConsoleAppException e) {
			System.out.printf("Errors : %s%n%n",e.getMessage());
			doBusiness();
		}catch(ValidationException e) {
			System.out.println();
			System.out.println("Validation Errors ");
			for(var message : e.getMessages()) {
				System.out.println(message);
			}
			System.out.println();
			doBusiness();
		}
		
	}

}
