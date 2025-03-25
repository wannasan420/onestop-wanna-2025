package com.wanna.student.controller;

import com.wanna.student.model.StudentModel;
import com.wanna.student.model.StudentOutput;

public class StudentUpdateController extends AbstractStudentController {

	public StudentUpdateController(int id, StudentModel model) {
		super(id, "Update Student ", model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBusiness() {
		var id = getStudentId();
		var student = model.findById(id);
		if(student != null) {
			var form = getStudentInfo();
			var result = model.update(id,form); 
			showResult(result);
		}else {
			errorMessageforStudentNotFound(id);
		}
		
		
		

	}

	private void showResult(StudentOutput result) {

		System.out.printf("%s has been updated successfully %n",result.getName());  
	}

}
