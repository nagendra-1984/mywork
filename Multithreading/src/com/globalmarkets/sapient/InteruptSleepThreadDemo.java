package com.globalmarkets.sapient;

public class InteruptSleepThreadDemo {
	
	public static void main (String args[]){
		
		System.out.println("^%^ Demo to interrupt an sleeping thread ^%^");
		try {		
			PrintNumbersUtil numberUtil = new PrintNumbersUtil();
			Thread printingThread = new Thread(numberUtil);
			printingThread.start();
		
			Thread.sleep(7000);
			printingThread.interrupt();
			
			System.out.println("^%^ Is Printing Thread Interrupted ^%^"+printingThread.isInterrupted());
			
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
