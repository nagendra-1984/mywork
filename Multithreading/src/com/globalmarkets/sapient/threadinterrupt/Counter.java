package com.globalmarkets.sapient.threadinterrupt;

public class Counter implements Runnable{

	public volatile boolean exit = false;
	
	public void exit(boolean exit){
		
		this.exit = exit;
	}
	
	
	@Override
	public void run() {
		try{
			// TODO Auto-generated method stub
			int i= 0;
			// Exit the thread when exit is true, the volatile variable can be updated by Main thread or another thread
			while(!exit){
				System.out.println("^%^ "+i);
				i++;
				Thread.sleep(1000);
			}
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}		
	}

}
