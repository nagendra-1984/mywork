package com.globalmarkets.sapient.collections;

public class ThreadSafeHashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 *  Implemented the ThreadSafe HashMap is using ConcurrentHashMap
		 *  Implemented the ThreadSafe HashMap is using SynchronizedHashMap
		 */
		System.out.println("^%^ Demo of ThreadSafe HashMap ^%^");
		ReadPerson readPerson = new ReadPerson();
		AddPerson addPerson = new AddPerson();
		
		Thread readPersonThread = new Thread(readPerson);
		Thread addPersonThread = new Thread(addPerson);
		
		readPersonThread.start();		
		addPersonThread.start();
		
		try {
			Thread.sleep(500000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
