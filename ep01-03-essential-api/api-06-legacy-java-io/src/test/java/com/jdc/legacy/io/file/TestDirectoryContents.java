package com.jdc.legacy.io.file;

import org.junit.jupiter.api.Test;

import com.jdc.legacy.io.DirectoryContents;

public class TestDirectoryContents {

	@Test
	void Test() {
		var service = new DirectoryContents();
		service.print("test");
	}
}
