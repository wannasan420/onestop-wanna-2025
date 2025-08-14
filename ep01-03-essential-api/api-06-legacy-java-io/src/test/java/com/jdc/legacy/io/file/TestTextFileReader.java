package com.jdc.legacy.io.file;

import org.junit.jupiter.api.Test;

import com.jdc.legacy.io.TextFileReader;

public class TestTextFileReader {

	@Test
	void test() {
		var service = new TextFileReader();
		var list = service.read("test/data.txt");
		System.out.println(list);
	}
}
