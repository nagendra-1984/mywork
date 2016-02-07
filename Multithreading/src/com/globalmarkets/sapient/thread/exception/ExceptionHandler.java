package com.globalmarkets.sapient.thread.exception;

public class ExceptionHandler {

	
	public static void main(String args[]){
		
		StringOperations strOperations = new StringOperations("Nagendra","Reddy");
		Thread strThread = new Thread(strOperations);
		strThread.setName("StringThread");
		
		// Declarring UnCaughtExceptionHandler to the Thread 
		// 
		strThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			// uncuaghtException Method recives Thread and Exception Object
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println(t.getName() + " throws exception: " + e);
			}
		});
		
		strThread.start();
	}
}
