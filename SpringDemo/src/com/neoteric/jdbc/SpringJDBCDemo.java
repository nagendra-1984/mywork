package com.neoteric.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJDBCDemo {

	
	   public static void main(String[] args) {
		   
		      System.out.println("^%^ Loading Application Context ^%^");
		      
		      ApplicationContext context =  new ClassPathXmlApplicationContext("jdbcbeans.xml");
		      
		      StudentJDBCTemplate studentJDBCTemplate = 
		      (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
		      
		      //studentJDBCTemplate.delete(2);
		      //studentJDBCTemplate.update(3, 30, "Nagarjuna");
		      
		      getStudentRecord(studentJDBCTemplate, 3);

		  
		   }
	   
	   /**
	    * 
	    * @param studentJDBCTemplate
	    */
	   public static void createUser(StudentJDBCTemplate studentJDBCTemplate){
		   
		      System.out.println("------Records Creation--------" );
		      studentJDBCTemplate.create(4,"Sweth", 11);
		      studentJDBCTemplate.create(5,"Nagendra", 2);
		      studentJDBCTemplate.create(6,"Krish", 15);
	   
	   }
	   
	   public static void deleteUser(StudentJDBCTemplate studentJDBCTemplate,int studentId){
		   
		   	System.out.println("-------Records Deletion--------");
		   	studentJDBCTemplate.delete(studentId);
		   	
	   }
	   
	   public static void getUsersList(StudentJDBCTemplate studentJDBCTemplate){
		   
		    System.out.println("------Listing Multiple Records--------" );
		    List<Student> students = studentJDBCTemplate.listStudents();
		      
		    System.out.println("^%^ students list size ^%^"+students.size());
		      for (Student record : students) {
		         System.out.print("ID : " + record.getId() );
		         System.out.print(", Name : " + record.getName() );
		         System.out.println(", Age : " + record.getAge());
		      }
	   }
	   
	   public static void updateUser(StudentJDBCTemplate studentJDBCTemplate,int studentId,int age, String strName){
		   
		      System.out.println("----Updating Record with ID = 2 -----" );
		      studentJDBCTemplate.update(studentId, age,strName);
	   }
	   

	   /**
	    * 
	    * @param studentJDBCTemplate
	    * @param studentId
	    */
	   public static void getStudentRecord(StudentJDBCTemplate studentJDBCTemplate,int studentId){
		   
		    System.out.println("------Listing Multiple Records--------" );
		    Student student = studentJDBCTemplate.getStudentRecord(studentId);
		      
		         System.out.print("ID : " + student.getId() );
		         System.out.print(", Name : " + student.getName() );
		         System.out.println(", Age : " + student.getAge());
		      }
}
