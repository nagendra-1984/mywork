package com.globalmarkets.sapient;

import java.text.SimpleDateFormat;

public class PrintTimeThread implements Runnable{
	
	private Thread joiningThread;
	private SimpleDateFormat date;
	
	@Override
	public void run() {
		date = new SimpleDateFormat("MM/DD/YYYY HH:MM:SS");
		// TODO Auto-generated method stub
		System.out.println("^%^ Starting Thread ^%^"+Thread.currentThread().getName()+ "^%^ at ^%^"+date.format(System.currentTimeMillis()));
		try{
		
			if(joiningThread!=null){
				joiningThread.join();
			}
			
			Thread.sleep(5000);
		}catch(InterruptedException ieExp){
			System.out.println("^%^ Caught InterruptedException ^%^");
		}
		System.out.println("^%^ Finishing Thread ^%^"+Thread.currentThread().getName()+"^%^ at ^%^"+date.format(System.currentTimeMillis()));
	}
	
	/**
	 * 
	 * @param joiningThread
	 */
	public void joinThread(Thread previousThread){
			this.joiningThread = previousThread;
	}

}
