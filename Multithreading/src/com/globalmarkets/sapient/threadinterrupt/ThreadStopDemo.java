package com.globalmarkets.sapient.threadinterrupt;

public class ThreadStopDemo {
	
	public static void main(String args[]){
		
		try{
			Counter counter = new Counter();
			Thread counterThread = new Thread(counter);
			counterThread.start();
			
			// Making the current Main Thread sleep for 10 secs 
			
			Thread.sleep(10000);
			// Updating the volatile variable on the Counter Object to exit the thread. 
			counter.exit(true);

		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}

}
