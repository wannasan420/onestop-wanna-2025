package com.wanna.student.controller;

import com.wanna.student.model.StudentModel;
import com.wanna.student.model.StudentOutput;

public class StudentDetailController extends AbstractStudentController {

	public StudentDetailController(int id, StudentModel model) {
		super(id, "Show Student Details ", model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBusiness() {

		var id = getStudentId();
		var result = model.findById(id);
		if(result != null) {
			showResult(result);
		}else {
			errorMessageforStudentNotFound(id);
		}
		
	}

	private void showResult(StudentOutput result) {
 
		System.out.printf(
				"""
				Student name : %s
				Phone        : %s
				Email        : %s
				Address      : %s
				""".formatted(result.getName(),result.getPhone(),result.getEmail(),result.getAddress()));
	}

}
