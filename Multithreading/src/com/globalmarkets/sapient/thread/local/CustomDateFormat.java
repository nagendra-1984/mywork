package com.globalmarkets.sapient.thread.local;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CustomDateFormat {
	
	private static final ThreadLocal<SimpleDateFormat> dateFormat
				= new ThreadLocal<SimpleDateFormat>();
	
	protected SimpleDateFormat initialValue(){
		
		System.out.println("^%^ Creating SimpleDateFormat for Each Thread ^%^"+Thread.currentThread().getName());
		return new SimpleDateFormat("dd/mm/yyyy");
	}
	
}
