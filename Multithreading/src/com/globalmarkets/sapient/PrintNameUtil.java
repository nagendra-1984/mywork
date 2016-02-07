package com.globalmarkets.sapient;

public class PrintNameUtil implements Runnable {
	
	PrintNameUtil(String strThreadName){		
		Thread.currentThread().setName(strThreadName);
	}

	public void run(){
		
		System.out.println("^%^ Thread Name ^%^"+Thread.currentThread().getName());

	}
}
