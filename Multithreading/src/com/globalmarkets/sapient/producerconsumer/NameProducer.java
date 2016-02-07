package com.globalmarkets.sapient.producerconsumer;

import java.util.*;
import java.util.concurrent.BlockingQueue;

public class NameProducer implements Runnable{
	
	private final BlockingQueue<String> blockingQueue;
	
	NameProducer(BlockingQueue<String> blockingQueue){
		this.blockingQueue = blockingQueue;
	}

	/**
	 * 
	 */
	public void run(){
		System.out.println("^%^ Producer ^%^");
		try{
		for(int i=0;i<5;i++){
			System.out.println("^%^ Adding Value_"+i);
			addName("Value_"+i);
		}
		}catch(InterruptedException ieExp){
			System.out.println("^%^ Interrupted Exception^%^"+ieExp.getLocalizedMessage());
		}		
	}
	
	
	/**
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
	private void addName(String strName) throws InterruptedException{
			blockingQueue.put(strName);
		}
}
