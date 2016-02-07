package com.globalmarkets.sapient.producerconsumerrealtime;

public class NumberUtility implements Runnable {
	
	private boolean isOdd = false;
	private volatile int countingNumber;
	private int maxNumber;
	private NumberGenerator numberGenerator;

	
	NumberUtility (int countingNumber,int maxNumber,boolean isOddNumber,NumberGenerator numberGenerator){
		this.countingNumber = countingNumber;
		this.maxNumber = maxNumber;
		this.isOdd= isOddNumber;
		this.numberGenerator = numberGenerator;
		
	}
	

	/**
	 * 
	 */
	public void run(){
		System.out.println("^%^ counting Number ^%^"+countingNumber);
		
		while(countingNumber<maxNumber){
			
			if(isOdd){
				numberGenerator.printOdd(countingNumber);
			}else{
				numberGenerator.printEven(countingNumber);
			}
			
			countingNumber = countingNumber+2;
		}
		
	}
	


	
}
