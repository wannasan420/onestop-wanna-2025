package com.wanna.calculator.feature;

public class FeatureForMultiplication extends AbstractCalculation{

	public FeatureForMultiplication(int id) {
		super(id, "Multipy Calculation ");
		
	}

	@Override
	public void doAddingAndShowResult(int first, int second) {
		System.out.printf("%d * %d = %d ",first,second,first*second);
		
	}

}
 