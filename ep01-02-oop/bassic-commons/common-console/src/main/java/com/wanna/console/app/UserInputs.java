package com.wanna.console.app;

import java.util.Scanner;

import com.wanna.console.app.exceptions.ConsoleAppException;

public class UserInputs {

	private static final Scanner scanner = new Scanner(System.in);

	public static String readString(String string) {
		
		System.out.printf("%s : ",string);
		return scanner.nextLine();
		
	}

	public static int readInt(String string) {
		try {
			var result = readString(string);
			return Integer.parseInt(result);
		} catch (NumberFormatException e) {
			throw new ConsoleAppException("Please Enter %s with Digit.".formatted(string), e);
		}
		
	}

	public static String readString(int size, String string) {
		
		String message = "%%-%ds ".formatted(size).formatted(string);
		return readString(message);
		
	}

	public static int readInt(int size, String string) {
		
		try {
			var result = readString(size, string);
			return Integer.parseInt(result);
		} catch (NumberFormatException e) {
			throw new ConsoleAppException("Please Enter %s with Digit.".formatted(string), e);
		}
	}

}
