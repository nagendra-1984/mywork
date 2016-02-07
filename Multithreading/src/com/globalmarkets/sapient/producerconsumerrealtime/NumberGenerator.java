package com.globalmarkets.sapient.producerconsumerrealtime;

public class NumberGenerator {

	public volatile boolean isOddPrinted = false;
	
	public synchronized void printOdd(int countingNumber){
		
		
			while(isOddPrinted == true){
					//System.out.println("^%^ Waiting for notificaton from Even Thread ^%^");
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					System.out.println("^%^ Odd Number ^%^"+countingNumber);
					isOddPrinted = true;
						notifyAll();
		}


	public synchronized void printEven(int countingNumber){
	
		while(isOddPrinted == false){
			//System.out.println("^%^ Waiting for notification from Odd Thread ^%^");
		
			try {
					wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
			System.out.println("^%^ Even Number ^%^"+countingNumber);
			isOddPrinted = false;
			notifyAll();

	
	}
}
