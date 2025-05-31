package com.wanna.calculator.feature;

import com.wanna.console.app.AbstractFeature;
import com.wanna.console.app.UserInputs;

public abstract class AbstractCalculation extends AbstractFeature {

	public AbstractCalculation(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBusiness() { 

		int first = getFirstNumber();

		int second = getSecondNumber(); 

		doAddingAndShowResult(first, second);
	}

	public abstract void doAddingAndShowResult(int first, int second);

	private int getSecondNumber() {

		return UserInputs.readInt("Second Digit : ");
	}

	private int getFirstNumber() {

		return UserInputs.readInt("First Digit : ");
	}
}
