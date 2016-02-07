package com.neoteric.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.TestCase;

public class EmployeeTestCase extends TestCase{

	   static EmpBusinessLogic empBusinessLogic =null;
	   static EmployeeDetails employee = null;

	   @Override
	   public void setUp(){
		   System.out.println("^%^ Loading te employee Class Objects ");
		   empBusinessLogic = new EmpBusinessLogic();
		   employee = new EmployeeDetails();
		      System.out.println("^%^ Loading Test Data ^%^");
		      employee.setName("Rajeev");
		      employee.setAge(25);
		      employee.setMonthlySalary(8000);

	   }
	   
	   // Postive Test 1
	   // Specify the Method Execution turn around time by using the Time Out Options.
	   //test to check appraisal
	   @Test(timeout=1000,expected = ArithmeticException.class)
	   public void testPostiveCalculateAppriasal() {
		      double appraisal= empBusinessLogic.calculateAppraisal(employee);
		      //Thread.sleep(3000);
		      assertEquals(500, appraisal, 0.0);
		    }
	

	   // Negative Test 1
	   // Specify the Method Execution turn around time by using the Time Out Options.
	   //test to check appraisal
	   @Test(timeout=1000,expected = ArithmeticException.class)
	   public void testNegativeCalculateAppriasal() {
		   employee.setMonthlySalary(13000);
		      double appraisal= empBusinessLogic.calculateAppraisal(employee);
		      //Thread.sleep(3000);
		      assertEquals(500, appraisal, 0.0);
		    }
	
	   
	   @Override
	   public void tearDown(){
		   System.out.println("^%^ Releasing the employee objs ^%^");
		   employee = null;
		   empBusinessLogic = null;
	   }
}
