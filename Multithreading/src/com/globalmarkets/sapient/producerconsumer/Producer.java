package com.globalmarkets.sapient.producerconsumer;

import java.util.*;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	
	private final Vector<String> sharedQueue;
	private final int vectorSize;
	private final BlockingQueue<String> blockingQueue;
	
	Producer(Vector<String> sharedQueue,int size){
		this.sharedQueue = sharedQueue;
		this.vectorSize = size;
		this.blockingQueue =null;
	}
	
	Producer(BlockingQueue<String> blockingQueue){
		this.blockingQueue = blockingQueue;
		this.sharedQueue = null;
		this.vectorSize = 0;

	}

	/**
	 * 
	 */
	public void run(){
		System.out.println("^%^ Producer ^%^");
		try{
		for(int i=0;i<vectorSize;i++){
			System.out.println("^%^ Adding Value_"+i);
			addElement("Value_"+i);
		}
		}catch(InterruptedException ieExp){
			System.out.println("^%^ Interrupted Exception^%^"+ieExp.getLocalizedMessage());
		}		
		System.out.println("^%^ Size of the Vector ^%^"+sharedQueue.size());
	}
	
	
	/**
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	private void addElement(String value) throws InterruptedException{
			
		while(sharedQueue.size() ==  vectorSize) {
			
			synchronized(sharedQueue){

				System.out.println("^%^ Queue is full ^%^"+Thread.currentThread().getName()+ " ^%^ is waiting for consumer ^%^");
		
				// Producer thread is waiting for the consumer thread to read the values , wait releases the locks on sharedQueue Object
				sharedQueue.wait();
			}
		}
		
		// Synchronizing the sharedQueue , fetching the lock on sharedQueue Object 		
			synchronized(sharedQueue){
			
				sharedQueue.addElement(value);
				sharedQueue.notify();	// notifying all other threads who are waiting for the locks on sharedQueue Object
			}
		
		}
}
