package com.globalmarkets.sapient;

public class PrintNumbersUtil implements Runnable {

	public void run(){
		
		System.out.println("^%^ Thread printing numbers from 1 to 1000 ^%^");
		
		try{
			for(int i=0;i< 1000;i++){
				
				// Calling Thread.interrupted() clears the Interrupt Status called by Other Theads
				// And Continues it work
				// Thread.interrupted();
				
				Thread.sleep(1000);
				System.out.println("^%^ Number ^%^"+i);
			}
		}catch(InterruptedException ieEx){
			System.out.println("^%^ Exception Strace ^%^"+ieEx.toString());
		}
	}
}
