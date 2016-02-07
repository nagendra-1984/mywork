package com.neoteric.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


// Qaulifying the class as Suite Class 
// Adding multiple test Classes to Suite Class
@RunWith(Suite.class)
@Suite.SuiteClasses(
		{TestEmployeeDetails.class,
			TestAssertionsMethods.class,
			TestEmployeeDetails.class}
		)
public class EmployeeSuiteClass {

}
