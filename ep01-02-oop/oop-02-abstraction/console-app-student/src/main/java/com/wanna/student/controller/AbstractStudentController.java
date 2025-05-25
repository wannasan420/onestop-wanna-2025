package com.wanna.student.controller;

import com.wanna.console.app.AbstractFeature;
import com.wanna.console.app.UserInputs;
import com.wanna.student.model.StudentForm;
import com.wanna.student.model.StudentModel;

public abstract class AbstractStudentController extends AbstractFeature {

	protected StudentModel model;

	public AbstractStudentController(int id, String name, StudentModel model) {
		super(id, name);
		this.model = model;
	}

	protected void errorMessageforStudentNotFound(int id) {
		System.out.printf("There is no student with id %d",id);
	}

	protected StudentForm getStudentInfo() {
		
		var form = new StudentForm();
		
		int size = 13;
		form.setName( UserInputs.readString(size,"Student Name"));
		form.setPhone(UserInputs.readString(size,"Phone Number"));
		form.setEmail(UserInputs.readString(size,"Email"));
		form.setAddress(UserInputs.readString(size,"Address"));
		
		 
		return form;
	}

	protected int getStudentId() {
		return UserInputs.readInt("Student Id : ");
	}

	
}
	
