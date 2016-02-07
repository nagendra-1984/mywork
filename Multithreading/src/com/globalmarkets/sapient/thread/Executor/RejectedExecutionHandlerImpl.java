package com.globalmarkets.sapient.thread.Executor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable run, ThreadPoolExecutor arg1) {
		// TODO Auto-generated method stub
		System.out.println(run.toString() + " is rejected");
	}

	
}
