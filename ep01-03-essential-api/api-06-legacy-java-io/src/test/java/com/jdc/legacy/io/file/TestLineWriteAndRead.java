package com.jdc.legacy.io.file;

import org.junit.jupiter.api.Test;

import com.jdc.legacy.io.LineWriteAndRead;

public class TestLineWriteAndRead {

	@Test
	void test() {
		
		var service = new LineWriteAndRead("data1.txt");
		service.start();
	}
}
