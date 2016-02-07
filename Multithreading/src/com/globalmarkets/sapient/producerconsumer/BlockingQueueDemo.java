package com.globalmarkets.sapient.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
	
	public static void main (String args[]){
		
		System.out.println("^%^ Blocking Queue Demo ^%^");
		try{
			 BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
			 queue.put("Nagendra");
			
			 NameProducer producer = new NameProducer(queue);
			 NameConsumer consumer = new NameConsumer(queue);
			 
			 Thread producerThread = new Thread(producer);
			 Thread consumerThread = new Thread(consumer);
			 
			 producerThread.start();
			 consumerThread.start();
			 
			 Thread.sleep(5000);
			 
			 
			 System.out.println("^%^ name Queue Size ^%^"+queue.size());
			 while(!queue.isEmpty()){
				 System.out.println("^%^ names ^%^"+queue.take());
			 }
			 
			 
			 
		}catch(InterruptedException ieExp){
			System.out.println("^%^ Exception thrown ^%^"+ieExp.toString());
		}
	}

}
