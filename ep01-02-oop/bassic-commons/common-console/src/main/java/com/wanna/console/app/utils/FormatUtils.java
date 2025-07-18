package com.wanna.console.app.utils;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public interface FormatUtils {

	String FMT_STRING = "%%-%ds";
	String FMT_NUMBER = "%%%ds";
	
	DecimalFormat DF = new DecimalFormat("#,##0.00");
	DateTimeFormatter DTTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	DateTimeFormatter DATEF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
}
