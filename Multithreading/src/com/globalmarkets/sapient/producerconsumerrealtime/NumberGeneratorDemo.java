package com.globalmarkets.sapient.producerconsumerrealtime;

public class NumberGeneratorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			System.out.println("^%^ Printing Odd & Even Numbers using two threads^%^");
	
	}
	
	public static void printAltNumbers(){
		
		System.out.println("^%^ Demo to print Alternate numbers ^%^");
		
		NumberGenerator numberGenerator = new NumberGenerator();
		NumberUtility oddNumberGenerator = new NumberUtility(1,10,true,numberGenerator);
		NumberUtility evenNumberGenerator = new NumberUtility(2,10,false,numberGenerator);
		
		Thread oddNumberThread = new Thread(oddNumberGenerator);
		Thread evenNumberThread = new Thread(evenNumberGenerator);
		
		oddNumberThread.start();
		evenNumberThread.start();
		
		
	}
}
