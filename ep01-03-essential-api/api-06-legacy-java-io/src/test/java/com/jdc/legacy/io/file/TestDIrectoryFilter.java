package com.jdc.legacy.io.file;

import org.junit.jupiter.api.Test;

import com.jdc.legacy.io.DirectoryFilter;

public class TestDIrectoryFilter {

	@Test
	void test() {
		var service = new DirectoryFilter();
		service.print("test", "txt");
	}
}
