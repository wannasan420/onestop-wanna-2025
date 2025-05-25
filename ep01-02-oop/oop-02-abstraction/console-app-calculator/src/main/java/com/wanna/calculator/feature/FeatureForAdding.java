package com.wanna.calculator.feature;

public class FeatureForAdding extends AbstractCalculation{

	public FeatureForAdding(int id) {
		super(id, "Plus Feature ");
		
	}
	
	
	@Override
	public void doAddingAndShowResult(int first, int second) {
		System.out.printf("%d + %d = %d ",first,second,first+second);
		
	}

	
	

	

	
}
