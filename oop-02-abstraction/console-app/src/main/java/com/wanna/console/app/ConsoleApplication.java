package com.wanna.console.app;

public class ConsoleApplication {

	private String AppName;
	private AbstractFeature[] features;
	
	public ConsoleApplication(String appName, AbstractFeature[] features) {
		super();
		AppName = appName;
		this.features = features;
	}
	
	public void launch() {
		showMessage("Welcome to %s ".formatted(AppName));
		do {
			
			var feature = getUserSelectedFeatures();
			
			System.out.println();
			
			feature.showMenu();
			
			System.out.println();
			feature.doBusiness();
			
			
		}while(AskToDoAgain());
		
		showMessage("See You Again. ");
	}
	
	private AbstractFeature getUserSelectedFeatures() {
		
		System.out.println("Please Choose One Option : ");
		
		for(var feature : features) {
			 
			feature.showMenu();
		}
		
		var selectedId = UserInputs.readInt("Feature Id: ");
		
		return features[selectedId -1 ];
		
	}

	private void showMessage(String message) {
		
		System.out.println("==============");
		System.out.println(message);
		System.out.println("==============");
		System.out.println();
		
	}

	private boolean AskToDoAgain() {
		System.out.println();
		System.out.println();
		var result = UserInputs.readString("Do you want to do agian? y/n : ");
		System.out.println();
		return "Y".equalsIgnoreCase(result);
	}
	
	
}
