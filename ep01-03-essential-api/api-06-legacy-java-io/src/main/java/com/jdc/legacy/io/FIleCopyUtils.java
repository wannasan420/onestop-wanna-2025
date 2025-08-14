package com.jdc.legacy.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIleCopyUtils {

	public static void copy(String source,String destination) {
		
		try(var input = new FileInputStream(source);
				var output = new FileOutputStream(destination)){
			
			byte[] buffer = new byte[1024];
			
			while(((input.read(buffer)) != -1)) {
				output.write(buffer);
				
			}
		}catch (IOException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
