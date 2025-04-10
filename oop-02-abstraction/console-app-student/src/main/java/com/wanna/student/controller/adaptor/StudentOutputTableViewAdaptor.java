package com.wanna.student.controller.adaptor;

import com.wanna.console.app.component.TableViewModel;
import com.wanna.student.model.StudentOutput;

public class StudentOutputTableViewAdaptor implements TableViewModel{

	StudentOutput[] array;
	
	private static final String ID = "ID";
	private static final String NAME = "Name";
	private static final String PHONE = "Phone";
	private static final String EMAIL = "Email";
	private static final String ADDRESS = "Address";
	
	private int idSize = ID.length() + 2;
	private int nameSize = NAME.length() + 2; 
	private int phoneSize = PHONE.length() + 2;
	private int emailSize = EMAIL.length() + 2;
	private int addressSize = ADDRESS.length() + 2;
	
	
	
	public StudentOutputTableViewAdaptor(StudentOutput[] array) {
		super();
		this.array = array;
		
		for(var data : this.array) {
			var id = String.valueOf(data.getId()).length() + 2;
			idSize = id > idSize ? id : idSize;
			
			var name = data.getName().length() + 2;
			nameSize = name > nameSize ? name : nameSize;
			
			var phone = data.getPhone().length() + 2;
			phoneSize = phone > phoneSize ? phone : phoneSize;
			
			var email = data.getEmail().length() + 2;
			emailSize = email > emailSize ? email : emailSize;
			
			var addr = data.getAddress().length() + 2;
			addressSize = addr > addressSize ? addr : addressSize;
		}
	}

	@Override
	public int MaxSize() {
		
		return idSize+nameSize+phoneSize+emailSize+addressSize;
	}

	@Override
	public String Header() {
		var format = getFormat();
		return format.formatted(ID,NAME,PHONE,EMAIL,ADDRESS);
	}

	private String getFormat() {
		var string = "%%-%ds %%-%ds %%-%ds %%-%ds %%-%ds";
		return string.formatted(idSize,nameSize,phoneSize,emailSize,addressSize);
	}

	@Override
	public String[] rows() {
		
		var rows = new String[this.array.length];
		
		var format = getFormat();
		
		for(int i= 0; i < array.length; i++) {
			var data = array[i];
			rows[i] = format.formatted(data.getId(),data.getName(),data.getPhone(),data.getEmail(),data.getAddress());
		}
		return rows;
	}

	
}
