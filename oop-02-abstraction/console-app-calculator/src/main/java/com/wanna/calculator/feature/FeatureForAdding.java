package com.wanna.calculator.feature;

import com.wanna.console.app.*;

public class FeatureForAdding extends AbstractFeature{

	public FeatureForAdding(int id) {
		super(id, "Plus Calculation ");
	}

	@Override
	public void doBusiness() {
				
		
		int first = getFirstNumber();
		
		int second = getSecondNumber();
		
		doAddingAndShowResult(first,second);
	}

	private void doAddingAndShowResult(int first, int second) {
		
		int result = first + second;
		
		System.out.printf("%d + %d = %d ",first,second,result);
		
		
	}

	private int getSecondNumber() {
		
		return  UserInputs.readInt("Second Digit : ");
	}

	private int getFirstNumber() {
		
		return UserInputs.readInt("First Digit : ");
	}

	

	
}
