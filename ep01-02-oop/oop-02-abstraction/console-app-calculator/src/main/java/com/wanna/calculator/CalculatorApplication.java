package com.wanna.calculator;

import com.wanna.calculator.feature.AbstractCalculation;
import com.wanna.calculator.feature.FeatureForAdding;
import com.wanna.calculator.feature.FeatureForDivision;
import com.wanna.calculator.feature.FeatureForMultiplication;
import com.wanna.calculator.feature.FeatureForSubstraction;
import com.wanna.console.app.AbstractFeature;
import com.wanna.console.app.ConsoleApplication;

public class CalculatorApplication {

	public static void main(String[] args) {
		
		
		var app = new ConsoleApplication("Calculator App",
				new FeatureForAdding(1),
				new FeatureForSubstraction(2),
				new FeatureForMultiplication(3),
				new FeatureForDivision(4),
				new AbstractCalculation(5,"Modulus Calculation") {
					@Override
					public void doAddingAndShowResult(int first, int second) {
						System.out.printf("%d %% %d = %d",first,second,first%second);
					}
		});
		app.launch();
	}
}
 