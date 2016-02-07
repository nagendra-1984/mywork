package com.globalmarkets.sapient.producerconsumerrealtime;

import java.util.Vector;

public class RealTimeProducerConsumerDemo {
	
	static volatile String statusMsg = "false";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			System.out.println("^%^ Demo Realtime Producer Consumer Solution^%^");
			Vector<String> sharedQueue = new Vector<String>();
			int size = 5;

			RealTimeProducer producer = new RealTimeProducer(sharedQueue,size);
			Thread producerThread = new Thread(producer,"Producer");
			RealTimeConsumer consumer = new RealTimeConsumer(sharedQueue,size);
			Thread consumerThread = new Thread(consumer,"Consumer");
			
			producerThread.start();
			consumerThread.start();
		
	}

}
