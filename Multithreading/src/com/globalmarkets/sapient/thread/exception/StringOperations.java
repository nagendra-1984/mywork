package com.globalmarkets.sapient.thread.exception;

public class StringOperations implements Runnable{
	
	String strFirstName;
	String strSecondName;

	// Default Empty Constructor
	public StringOperations(){
		
	}
	
	// Overloaded Constructor passing firstName and Second Name
	public StringOperations(String strFirstName,String strSecondName){
		this.strFirstName = strFirstName;
		this.strSecondName = strSecondName;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// Throwing Runtime Exception to the Handler 
		System.out.println("^%^ Full Name %^%^"+strFirstName.concat(strSecondName));
	
	}

	
}
