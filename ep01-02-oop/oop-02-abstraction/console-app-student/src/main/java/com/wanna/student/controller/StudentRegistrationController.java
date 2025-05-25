package com.wanna.student.controller;

import com.wanna.student.model.StudentModel;
import com.wanna.student.model.StudentOutput;

public class StudentRegistrationController extends AbstractStudentController {

	public StudentRegistrationController(int id, StudentModel model) {
		super(id, "Student Registration ", model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBusiness() {
		
		var form = getStudentInfo();
		var result = model.createStudent(form);
		showResult(result);
	}

	private void showResult(StudentOutput result) {

		System.out.printf("%s has been registered at %d %n",result.getName(),result.getId()); 
	}

}
