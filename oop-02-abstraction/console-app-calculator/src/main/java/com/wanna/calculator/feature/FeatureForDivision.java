package com.wanna.calculator.feature;

public class FeatureForDivision extends AbstractCalculation {

	public FeatureForDivision(int id) {
		super(id, "Divide Calculation");
		
	}

	@Override
	public void doAddingAndShowResult(int first, int second) {
		System.out.printf("%d / %d = %d ",first,second,first/second);
		
	}

}
