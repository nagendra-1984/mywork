package com.globalmarkets.sapient.producerconsumerrealtime;

import java.util.*;

public class RealTimeProducer implements Runnable{
	
	private final Vector<String> sharedQueue;
	private final int vectorSize;
	
	RealTimeProducer(Vector<String> sharedQueue,int size){
		this.sharedQueue = sharedQueue;
		this.vectorSize = size;
	}

	public void run(){
		System.out.println("^%^ Producer ^%^");
		try{
		for(int i=0;i<vectorSize;i++){
			System.out.println("^%^ Adding Value_"+i);
			addElement("Value_"+i);
			Thread.sleep(1000);
		}
		}catch(InterruptedException ieExp){
			System.out.println("^%^ Interrupted Exception^%^"+ieExp.getLocalizedMessage());
		}		
		System.out.println("^%^ Size of the Vector ^%^"+sharedQueue.size());
	}
	
	private void addElement(String value) throws InterruptedException{

		// Getting the lock on the Shared Object 
		synchronized(sharedQueue){
			// Checking the Shared Object Size 
			while(sharedQueue.size() ==  vectorSize) {
    				System.out.println("^%^ Current Thread Holds Lock ^%^"+Thread.holdsLock(sharedQueue));
					System.out.println("^%^ Queue is full ^%^"+Thread.currentThread().getName()+ " ^%^ is waiting for consumer ^%^");
					// Producer thread is waiting for the consumer thread to read the values , wait releases the locks on sharedQueue Object
					sharedQueue.wait();
				}
			
			sharedQueue.addElement(value);
			sharedQueue.notify();	// notifying all other threads who are waiting for values in sharedQueue
			}
		}
}
