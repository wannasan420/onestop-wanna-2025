package com.jdc.wanna.pos.features;

import static com.jdc.wanna.pos.model.AbstractModel.validate;

import java.util.Arrays;

import com.jdc.wanna.pos.model.ProductModel;
import com.jdc.wanna.pos.model.SaleModel;
import com.jdc.wanna.pos.model.input.SaleItem;
import com.jdc.wanna.pos.utils.ProductTableHelper;
import com.wanna.console.app.AbstractFeature;
import com.wanna.console.app.UserInputs;
import com.wanna.console.app.exceptions.BusinessException;
import com.wanna.console.app.exceptions.ConsoleAppException;
import com.wanna.console.app.exceptions.ValidationException;
import com.wanna.console.app.utils.FormatUtils;

public class FeatureForAddSale extends AbstractFeature {

	private static final int SIZE = 12;

	public FeatureForAddSale(int id) {
		super(id, "Create Sale");
	}

	@Override
	public void doBusiness() { 
		 
		SaleItem[] cart = {};
		
		System.out.println("Please select products.");
		var products = ProductModel.getInstance().search(null);
		ProductTableHelper.getTableView(products).draw();
		System.out.println();
		
		var skipAsking = false;
		do {
			
			try { 
				skipAsking = false;
				System.out.println("Add Item.");
				var id = UserInputs.readInt(SIZE, "Product ID");
				var product = ProductModel.getInstance().findById(id);
				
				System.out.printf("%-10s : %s%n","Name",product.name());
				System.out.printf("%-10s : %s%n","Price",FormatUtils.DF.format(product.price()));
				
				var quantity = UserInputs.readInt(SIZE,"Quantity");
				
				var item = new SaleItem(product, quantity);
				validate(item); 
				cart = addItem(item, cart);
				System.out.printf("%-10s : %s%n%n","Total",FormatUtils.DF.format(item.getTotal()));
				System.out.println();
			}catch (BusinessException | ConsoleAppException e) {
				System.out.printf("Error : %s%n%n",e.getMessage());
				skipAsking = true;
			}catch(ValidationException e) {
				System.out.println();
				System.out.println("Validation Error ");
				for(var message : e.getMessages()) {
					System.out.println(message);
				}
				System.out.println();
				skipAsking = true;

			}
		} while (skipAsking || !isEmptyInCart());
		if(cart.length > 0) {
			
			var sale = SaleModel.getInstance().create(cart);
			System.out.println("Sale History");
			
			System.out.printf("%-10s : %s%n","Sale ID",sale.id());
			System.out.printf("%-10s : %s%n","Item Amout",sale.getItemCount());
			System.out.printf("%-10s : %s%n","All Total",FormatUtils.DF.format(sale.getAllTotal()));
		}
		
	}

	private SaleItem[] addItem(SaleItem item, SaleItem[] cart) {
		
		var newCart = Arrays.copyOf(cart, cart.length+1);
		newCart[newCart.length-1] = item;
		return newCart;
	}

	private boolean isEmptyInCart() {
		
		var result = UserInputs.readString("Add more? (y/n)");
		System.out.println();
		return !"Y".toLowerCase().equals(result.toLowerCase()); 
	}

}
