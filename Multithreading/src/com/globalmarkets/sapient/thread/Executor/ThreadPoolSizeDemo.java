package com.globalmarkets.sapient.thread.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolSizeDemo {

	private static final int THREAD_POOL_SIZE=2;
	public static void main(String args[]){
		
		System.out.println("^%^ Demo class for using Thread Pool Size and Executor Service ^%^");
		try {
		ExecutorService executorProg = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		

		PrintNameUtil task = null;
		
		for(int i=0;i<6;i++){
			task = new PrintNameUtil("Thread_"+i);
			
			executorProg.execute(task);
		}
		executorProg.shutdown();
		executorProg.awaitTermination(1, TimeUnit.MINUTES);
		System.out.println("^%^ Executor Program is termitted ^%^"+executorProg.isTerminated());
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
