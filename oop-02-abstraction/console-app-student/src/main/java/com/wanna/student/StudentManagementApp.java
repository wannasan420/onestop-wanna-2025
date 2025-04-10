package com.wanna.student;

import com.wanna.console.app.ConsoleApplication;
import com.wanna.student.controller.StudentDetailController;
import com.wanna.student.controller.StudentRegistrationController;
import com.wanna.student.controller.StudentSearchController;
import com.wanna.student.controller.StudentUpdateController;
import com.wanna.student.model.StudentModelImpl;

public class StudentManagementApp {

	public static void main(String[] args) {

		
		var model = new  StudentModelImpl();
		var app = new ConsoleApplication("Student Management System",
				new StudentRegistrationController(1, model),
				new StudentDetailController(2, model),
				new StudentUpdateController(3, model),
				new StudentSearchController(4, model));

		app.launch();
	}


}
