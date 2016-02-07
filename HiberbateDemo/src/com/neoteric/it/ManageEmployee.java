package com.neoteric.it;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class ManageEmployee {
	
	   /* Method to CREATE an employee in the database */
	   public Integer addEmployee(String fname, String lname, int salary,SessionFactory sessionFactory){
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = new Employee(fname, lname, salary);
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return employeeID;
	   }


	   /* Method to CREATE an employee in the database */
	   public Integer addAddress(String street, String city, String state,String zipcode,SessionFactory sessionFactory){
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      Integer addressID = null;
	      try{
	         tx = session.beginTransaction();
	         Address address = new Address(street, city, state,zipcode);
	         addressID = (Integer) session.save(address); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return addressID;
	   }
	   
	   /* Method to CREATE an employee in the database */
	   public Integer addEmployeeAddress(String fname, String lname, int salary,Address address,HashSet<Certificate> certificates,SessionFactory sessionFactory){
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = new Employee(fname, lname, salary,address,certificates);
	        // employee.setCertificate(certificates);
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return employeeID;
	   }
	   
	   /* Method to CREATE an employee in the database */
	   public Integer addEmployeeCertificates(String fname, String lname, int salary,Address address,HashSet<Certificate> certificates,SessionFactory sessionFactory){
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = new Employee(fname, lname, salary,address);
	         employee.setEmpCertificate(certificates);
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return employeeID;
	   }

	   
	   /* Method to  READ all the employees */
	   public void listEmployees(SessionFactory factory){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         
	      
	         //List employees = session.createQuery("FROM Employee").list(); 
	         Query hqlQuery = session.createQuery("FROM Employee");
	         hqlQuery.setFirstResult(1);
	         hqlQuery.setMaxResults(5);
	         List employees = hqlQuery.list();
	         
	         for (Iterator iterator = 
	                           employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println("  Salary: " + employee.getSalary()); 
	            System.out.println("Employee Address : "+employee.getAddress().getStreet()+" : "+employee.getAddress().getCity());
	            
	            Set<Certificate> empCertSet = employee.getCertificate();
	            
	            for(Certificate empCert:empCertSet){
	            	
	            	System.out.println("^%^ Employee Cert ^%^"+empCert.getName());
	            }
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   
	   /* Method to  READ all the employees */
	   public void getEmployeeDetails(int employeeId,SessionFactory factory){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      String strHqlQuery="";
	      try{
	         tx = session.beginTransaction();
	         strHqlQuery ="FROM Employee E WHERE E.id = :employee_id";
	         Query employQuery = session.createQuery(strHqlQuery);
	         employQuery.setParameter("employee_id", employeeId);
	         
	         List employees = employQuery.list(); 
	         for (Iterator iterator = 
	                           employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println("  Salary: " + employee.getSalary()); 
	            System.out.println("Employee Address : "+employee.getAddress().getStreet()+" : "+employee.getAddress().getCity());
	            
	            Set<Certificate> empCertSet = employee.getCertificate();
	            
	            for(Certificate empCert:empCertSet){
	            	
	            	System.out.println("^%^ Employee Cert ^%^"+empCert.getName());
	            }
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }

	   /* Method to  READ all the employees */
	   public void getEmployeeDetailsByCriteria(int employeeId,SessionFactory factory){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try{
	         tx = session.beginTransaction();
	         Criteria empCriteria = session.createCriteria(Employee.class);
	         Criterion empidRes = Restrictions.eq("id", employeeId);
	         Criterion empsalRes = Restrictions.eq("salary", 1000);
	         empCriteria.add(Restrictions.or(empidRes,empsalRes));
		         
	         List employees = empCriteria.list();
	         for (Iterator iterator = 
	                           employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println("  Salary: " + employee.getSalary()); 
	            System.out.println("Employee Address : "+employee.getAddress().getStreet()+" : "+employee.getAddress().getCity());
	            
	            Set<Certificate> empCertSet = employee.getCertificate();
	            
	            for(Certificate empCert:empCertSet){
	            	
	            	System.out.println("^%^ Employee Cert ^%^"+empCert.getName());
	            }
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to  READ all the employees */
	   public void getEmployeeDetailsBySQL(int employeeId,SessionFactory factory){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try{
	         tx = session.beginTransaction();
	          Query query= session.getNamedQuery("employeeDetails").setParameter("employeeId", employeeId);
	          List employees = query.list();
	         for (Iterator iterator = 
	                           employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println("  Salary: " + employee.getSalary()); 
	            System.out.println("Employee Address : "+employee.getAddress().getStreet()+" : "+employee.getAddress().getCity());
	            
	            Set<Certificate> empCertSet = employee.getCertificate();
	            
	            for(Certificate empCert:empCertSet){
	            	
	            	System.out.println("^%^ Employee Cert ^%^"+empCert.getName());
	            }
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   
	   public void updateEmployee(Integer EmployeeID, int salary,SessionFactory factory ){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      try{
		         tx = session.beginTransaction();
		         Employee employee = 
		                    (Employee)session.get(Employee.class, EmployeeID); 
		         employee.setSalary( salary );
		         
				 session.update(employee); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		   }
	   
	   
	   /**
	    * 
	    * @param EmployeeID
	    * @param salary
	    * @param factory
	    */
	   public void updateEmployeeHQL(Integer EmployeeID, int salary,SessionFactory factory ){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      String updateHQLQuery="";
		      Integer result=0;
		      try{
		         tx = session.beginTransaction();
		         updateHQLQuery ="Update Employee E set E.salary=:salary where E.id = :employeeId";
		         Query hqlQuery = session.createQuery(updateHQLQuery);
		         hqlQuery.setParameter("salary", salary);
		         hqlQuery.setParameter("employeeId", EmployeeID);		         
				 result = hqlQuery.executeUpdate();
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		   }
	   
	   
		   /* Method to DELETE an employee from the records */
		   public void deleteEmployee(Integer EmployeeID,SessionFactory factory){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      try{
		         tx = session.beginTransaction();
		         Employee employee = 
		                   (Employee)session.get(Employee.class, EmployeeID); 
		         session.delete(employee); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		   }
}
