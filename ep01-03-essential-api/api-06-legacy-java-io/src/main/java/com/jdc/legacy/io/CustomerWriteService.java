package com.jdc.legacy.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerWriteService {

	private static final String FILE = "customer.obj";
	private int id;
	private Scanner scanner = new Scanner(System.in);
	private List<Customer> list = new ArrayList<>();
	public void start() {
		  
		while(true) {
			
			System.out.println("Add customer.");
			
			var customer = getCustomer();
			
			if(null == customer) {
				break;
			}
			list.add(customer);
			System.out.println();
		}
		
		saveCustomer();
	}

	private void saveCustomer() {
		
		try(var output = new ObjectOutputStream(new FileOutputStream(FILE))) {
			output.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Customer getCustomer() {
		System.out.print("Customer name : ");
		var name = scanner.nextLine();
		if(null == name || name.isEmpty()) {
			return null;
		}
		System.out.print("Customer phone :");
		var phone = scanner.nextLine();
		if(null == phone || phone.isEmpty()) {
			return null;
		}
		
		Customer customer = new Customer();
		customer.setName(name);
		customer.setPhone(phone);
		customer.setId(id);
		
		return customer; 
	}
}
