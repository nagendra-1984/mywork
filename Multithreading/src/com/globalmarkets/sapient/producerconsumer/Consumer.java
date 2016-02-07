package com.globalmarkets.sapient.producerconsumer;

import java.util.Vector;

public class Consumer implements Runnable {

	private final Vector<String> sharedQueue;
	private final int vectorSize;
	
	Consumer(Vector<String> sharedQueue,int size){
		this.sharedQueue = sharedQueue;
		this.vectorSize = size;
		
	}

	public void run(){
		System.out.println("^%^ Consumer ^%^");
		boolean statusFlag=true;
		try{
			Thread.sleep(5000);
			while(statusFlag)	
			{
				statusFlag = readElement(sharedQueue);
			}
		}catch(InterruptedException ieExp){
			System.out.println("^%^ Interrupted ^%^"+ieExp.getStackTrace());
		}
	
	}
	
	private boolean readElement(Vector<String> sharedQueue) throws InterruptedException{
		
		if(sharedQueue.isEmpty()){
			
				System.out.println("^%^ Array is empty...Waiting for the values ^%^"+sharedQueue.size());
				return false;
		}
		else {
		
			synchronized(sharedQueue){
			sharedQueue.notify();
			System.out.println("^%^ Reading Values ^%^"+sharedQueue.remove(0));
			}
			return true;
		}
		
	}
}
