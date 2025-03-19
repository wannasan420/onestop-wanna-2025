package com.wanna.calculator.feature;

public class FeatureForSubstaction extends AbstractCalculation{

	public FeatureForSubstaction(int id) {
		super(id,"Substract Calculation");
		
	}

	@Override
	public void doAddingAndShowResult(int first, int second) {
		System.out.printf("%d - %d = %d ",first,second,first-second);
		
	}

	

}
