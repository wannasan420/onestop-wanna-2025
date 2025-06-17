package com.wanna.console.app;

import com.wanna.console.app.exceptions.ConsoleAppException;

public class ConsoleApplication {

	private String AppName;
	private AbstractFeature[] features;
	
	public ConsoleApplication(String appName, AbstractFeature... features) {
		super();
		AppName = appName;
		this.features = features;
	}
	
	public void launch() {
		showMessage("Welcome to %s ".formatted(AppName));
		
		boolean skipAsking;
		
		do {
			skipAsking = false;
			
			try {
				var feature = getUserSelectedFeatures();
				
				System.out.println(); 
				 
				feature.showMenu();
				
				System.out.println();
				feature.doBusiness();
			} catch (ConsoleAppException e) {
				System.out.printf("Error : %s%n%n",e.getMessage());
				skipAsking = true;
			}
			
			
			
		}while(skipAsking || AskToDoAgain());
		
		showMessage("See You Again. ");	
	
	}
	
	private AbstractFeature getUserSelectedFeatures() {
		
		try {
			System.out.println("Please select menu : ");
			 
			for(var feature : features) {
				 
				feature.showMenu();   
			}
			System.out.println();
			var selectedId = UserInputs.readInt("Feature Id");
			
			return features[selectedId -1 ];
			
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ConsoleAppException("Please Enter valid Feature Id", e);
		}
		
		
	}

	private void showMessage(String message) {
		
		System.out.println("======================================");
		System.out.println(message);
		System.out.println("======================================");
		System.out.println();
		
	}

	private boolean AskToDoAgain() {
		System.out.println();
		System.out.println();
		var result = UserInputs.readString("Do you want to do agian? y/n ");
		System.out.println();
		return "Y".equalsIgnoreCase(result);
	}
	
	
}
