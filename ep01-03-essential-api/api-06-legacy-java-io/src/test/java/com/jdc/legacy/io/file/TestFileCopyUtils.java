package com.jdc.legacy.io.file;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.jdc.legacy.io.FIleCopyUtils;

public class TestFileCopyUtils {

	@Test
	void test() {
		
		var source = "/Users/wannasan/Downloads/Statement of Purpose.pdf";
		
		assertDoesNotThrow(() -> FIleCopyUtils.copy(source, "test/sop.pdf"));
	}
}
