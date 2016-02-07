package com.globalmarkets.sapient.producerconsumer;

import java.util.Vector;

public class ProducerConsumerDemo {
	
	static volatile String statusMsg = "false";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			System.out.println("^%^ Demo Producer Consumer Solution^%^");
			Vector<String> sharedQueue = new Vector<String>();
			int size = 5;

			Producer producer = new Producer(sharedQueue,size);
			Thread producerThread = new Thread(producer,"Producer");
			Consumer consumer = new Consumer(sharedQueue,size);
			Thread consumerThread = new Thread(consumer,"Consumer");
			
			producerThread.start();
			consumerThread.start();
		
	}

}
