package com.globalmarkets.sapient.producerconsumerrealtime;

import java.util.Vector;

public class RealTimeConsumer implements Runnable {

	private final Vector<String> sharedQueue;
	private final int vectorSize;
	
	RealTimeConsumer(Vector<String> sharedQueue,int size){
		this.sharedQueue = sharedQueue;
		this.vectorSize = size;
		
	}

	public void run(){
		System.out.println("^%^ Consumer ^%^");
		//boolean statusFlag=true;
		try{
			Thread.sleep(0);
			while(true)	
			{
				readElement(sharedQueue);
			}
		}catch(InterruptedException ieExp){
			System.out.println("^%^ Interrupted ^%^"+ieExp.getStackTrace());
		}
	
	}
	
	private void readElement(Vector<String> sharedQueue) throws InterruptedException{
		
		synchronized(sharedQueue){
			
			if(sharedQueue.isEmpty()){
					System.out.println("^%^ Array is empty.. Size--> ^%^"+sharedQueue.size());
					sharedQueue.wait();
				}

			System.out.println("^%^ Reading Values ^%^"+sharedQueue.remove(0));
			sharedQueue.notify();
			}
	}
}
