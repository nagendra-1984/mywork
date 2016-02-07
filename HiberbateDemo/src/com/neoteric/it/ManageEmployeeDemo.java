package com.neoteric.it;

import java.util.HashSet;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Set;

public class ManageEmployeeDemo {
	
    private static SessionFactory factory; 
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
	      try{
	    	  
	    	 Configuration cfg = new Configuration();
	    	 //cfg.addResource("hibernate.cfg.xml");
	    	 //cfg.setProperties(System.getProperties());
	    	 
	    	 cfg.configure("hibernate.cfg.xml");
	    	 SessionFactory sessionFactory = cfg.buildSessionFactory();
	    	 
	    	 
	         factory = new Configuration().configure().buildSessionFactory();
	         
	         /* Add few employee records in database */
	         ManageEmployee manageEmployee= new ManageEmployee();
	         Address address = new Address("2475 SW Street","Topeka","KS","02148");
	         HashSet<Certificate> empCertSet = new HashSet<Certificate>();
	         empCertSet.add(new Certificate(".Net Developer Certificate"));
	         empCertSet.add(new Certificate("Share Point Certificate"));
	         
		         
	         //manageEmployee.addEmployeeCertificates("Nagarjuna", "Reddy", 1000,address,empCertSet,factory);
	         //System.out.println("^%^ employee id ^%^"+empID1);
	         //manageEmployee.listEmployees(factory);
	         // manageEmployee.deleteEmployee(21, factory);
	         //manageEmployee.addAddress("kennedy Drive", "Malden", "MA", "02148", factory);
	        // manageEmployee.updateEmployeeHQL(19, 98676, factory);
	         //manageEmployee.getEmployeeDetails(19, factory);
	         manageEmployee.getEmployeeDetailsBySQL(19,factory);
	         
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
}