package com.neoteric;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MessageJUnitRunner {
	
	public static void main(String args[]){
		
		Result result = JUnitCore.runClasses(MessageJUnit.class);
		
		List<Failure> failures = result.getFailures();
		
		for(Failure failure:failures){
			System.out.println("^%^ Failure Message ^%^"+failure.getMessage());
			System.out.println("^%^ Failure Message ^%^"+failure.toString());
		}
		
		System.out.println("^%^ Test Result ^%^"+result.wasSuccessful());
	}

}
