package com.wanna.calculator;

import com.wanna.calculator.feature.FeatureForAdding;
import com.wanna.calculator.feature.FeatureForSubstaction;
import com.wanna.console.app.AbstractFeature;
import com.wanna.console.app.ConsoleApplication;

public class CalculatorApplication {

	public static void main(String[] args) {
		var features = new AbstractFeature[] {
				new FeatureForAdding(1),
				new FeatureForSubstaction(2)
		};
		
		var app = new ConsoleApplication("Calculator App", features);
		
		app.launch();
	}
	
}
