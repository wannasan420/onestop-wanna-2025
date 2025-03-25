package com.wanna.student.controller;

import com.wanna.console.app.UserInputs;
import com.wanna.console.app.component.TableView;
import com.wanna.console.app.component.TableViewModel;
import com.wanna.student.controller.adaptor.StudentOutputTableViewAdaptor;
import com.wanna.student.model.StudentModel;
import com.wanna.student.model.StudentOutput;

public class StudentSearchController extends AbstractStudentController {

	public StudentSearchController(int id, StudentModel model) {
		super(id, "Search Student ", model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBusiness() {
		var keyword = UserInputs.readString("Keyword for search : ");
		var result = model.search(keyword);
		showResult(result);
	}

	private void showResult(StudentOutput[] result) { 

		var tableViewModel = new StudentOutputTableViewAdaptor(result);
		var tableView = new TableView(tableViewModel);
		tableView.draw();
	}

}
