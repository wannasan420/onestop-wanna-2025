package com.jdc.legacy.io;

import java.io.File;

public class DirectoryContents {

	public void print(String path) {
		
		var directory = new File(path);
		
		if(directory.isDirectory()) {
			
			System.out.printf("Directory -> %s%n",path);
			var children = directory.listFiles();
			for(var child : children ) {
				print(child.getPath());
			}
		}else {
			System.out.printf("File -> %s%n",path);
		}
	}
}
