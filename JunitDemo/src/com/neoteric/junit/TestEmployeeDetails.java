package com.neoteric.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class TestEmployeeDetails {

	   static EmpBusinessLogic empBusinessLogic =null;
	   static EmployeeDetails employee = null;
	   
	   public TestEmployeeDetails() {
		// TODO Auto-generated constructor stub
	}

	   // Execute this method only once in the starting 
	   @BeforeClass
	   public static void loadObjs(){
		   System.out.println("^%^ Loading te employee Class Objects ");
		   empBusinessLogic = new EmpBusinessLogic();
		   employee = new EmployeeDetails();
		   
	   }
	
	   
	   //Execute this method for each test 
	   @Before
	   public void loadTestData(){
		      System.out.println("^%^ Loading Test Data ^%^");
		      employee.setName("Rajeev");
		      employee.setAge(25);
		      employee.setMonthlySalary(8000);
	   }
	   
	   // Test 1
	   // Specify the Method Execution turn around time by using the Time Out Options.
	   //test to check appraisal
	   @Test(timeout=1000)
	   public void verifyCalculateAppriasal() {
		 
		      double appraisal= empBusinessLogic.calculateAppraisal(employee);
		      //Thread.sleep(3000);
		      assertEquals(500, appraisal, 0.0);
		    }

	   // Test 1 with Ignore option
	   // test to check yearly salary
	  @Test(timeout=1000)
	   public void testCalculateYearlySalary() {
	      double salary= empBusinessLogic.calculateYearlySalary(employee);
	      assertEquals(95850, salary, 100.0);
	      
	   }
	   

	   // Executed for each test after completing the test
	   @After
	   public void relData(){
		   System.out.println("^%^ Releasing the employee data ^%^");
	   }
	   
	   // Execute only once before leaving the class
	   @AfterClass
	   public static void relObj(){
		   System.out.println("^%^ Releasing the employee objs ^%^");
		   employee = null;
		   empBusinessLogic = null;
				   
	   }
}
