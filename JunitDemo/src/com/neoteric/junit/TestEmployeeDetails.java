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

	   // Execute this method only once in the starting 
	   @BeforeClass
	   public static void loadObjs(){
		   System.out.println("^%^ Loading te employee Class Objects ");
		   empBusinessLogic = new EmpBusinessLogic();
		   employee = new EmployeeDetails();
		   
	   }
	
	   // Constructor used by the Parametrized running class
	   public TestEmployeeDetails(String strName,int age,int monthlySal){
		   System.out.println("^%^ Creating new Employee Object &^&");
		   employee.setName(strName);
		   employee.setAge(age);
		   employee.setMonthlySalary(monthlySal);
		   
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
	   @Test(timeout=1000,expected = ArithmeticException.class)
	   public void testCalculateAppriasal() {
		 
		      double appraisal= empBusinessLogic.calculateAppraisal(employee);
		      //Thread.sleep(3000);
		      assertEquals(500, appraisal, 0.0);
		    }

	   // Test 1 with Ignore option
	   // test to check yearly salary
	   @Ignore
	   public void testCalculateYearlySalary() {
	      double salary= empBusinessLogic.calculateYearlySalary(employee);
	      assertEquals(96000, salary, 0.0);
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
