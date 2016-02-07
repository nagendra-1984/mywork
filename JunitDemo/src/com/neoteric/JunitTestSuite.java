package com.neoteric;

import junit.framework.TestResult;
import junit.framework.TestSuite;

public class JunitTestSuite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating a suite where we can execute multiple test cases at one go
		TestSuite suite = new TestSuite(AssertMethodsJUnit.class,MessageJUnit.class);
		TestResult result = new TestResult();
		suite.run(result);
		System.out.println("^%^ Number of Test Case ^%^"+result.runCount());
		System.out.println("^%^ Number of Test Case Errors ^%^"+result.errorCount());
		System.out.println("^%^ Number of Test Case  Failure ^%^"+result.failureCount());
			
		
	
	}

}
