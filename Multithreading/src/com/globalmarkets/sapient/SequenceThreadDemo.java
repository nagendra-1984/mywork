package com.globalmarkets.sapient;

public class SequenceThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("^%^ Demo of Sequence Threads^%^");
		
			System.out.println("^%^ Current Thread ^%^"+Thread.currentThread().getName());
			
			PrintTimeThread timeThread1 = new PrintTimeThread();
			PrintTimeThread timeThread2 = new PrintTimeThread();
			PrintTimeThread timeThread3 = new PrintTimeThread();
			
			Thread t1 = new Thread(timeThread1);
			Thread t2 = new Thread(timeThread2);
			Thread t3 = new Thread(timeThread3);
			
			t1.setName("FirstThread");
			t2.setName("SecondThread");
			t3.setName("ThirdThread");
		
/*			timeThread1.joinThread(t2);
			timeThread2.joinThread(t3);
		
			t1.start();			
			t2.start();
			t3.start();	
*/			
			
			
			
			/**
			 *  Simpler way to make sure one thread runs after another is to tie them to main thread.
			 *  
			 */
		try{
				
				t1.start();
				t1.join();
				t2.start();
				t2.join();
				t3.start();
				t3.join();
				
		}catch(InterruptedException ieEx){
			ieEx.printStackTrace();
		}	
	}

}
