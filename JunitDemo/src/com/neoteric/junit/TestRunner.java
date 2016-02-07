package com.neoteric.junit;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Result result = JUnitCore.runClasses(TestAssertionsMethods.class);
		
		List<Failure> failures = result.getFailures();
		
		for(Failure failure:failures){
			System.out.println("^%^ Failure Mesages"+failure.getMessage());
		}
		System.out.println("^%^ no of Cases ^%^"+result.getRunCount());
		System.out.println("^%^ test run status ^%^"+result.wasSuccessful());
		
	}

}
