package com.globalmarkets.sapient.producerconsumer;

import java.util.Vector;
import java.util.concurrent.BlockingQueue;

public class NameConsumer implements Runnable {

	private final BlockingQueue<String> blockingQueue;
	
	NameConsumer(BlockingQueue<String> blockingQueue){
		this.blockingQueue = blockingQueue;
			
	}

	public void run(){
		System.out.println("^%^ Consumer ^%^");
		readName();
	}

	public void readName(){
		try{
			while(!blockingQueue.isEmpty()){
				System.out.println("^%^ Names from Consumer ^%^"+blockingQueue.take());
			}
		}catch(InterruptedException ieExp){
			System.out.println("^%^ Interrupted ^%^"+ieExp.getStackTrace());
		}

	}

}
