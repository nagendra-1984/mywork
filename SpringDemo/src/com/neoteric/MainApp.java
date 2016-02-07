package com.neoteric;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main (String args[]){
		
		System.out.println("^%^ Loading Spring Application Context ^%^");
		
			ApplicationContext appContext = new ClassPathXmlApplicationContext("Beans.xml");
			HelloWorld helloWorld1 = (HelloWorld)appContext.getBean("helloWorld");
			System.out.println("^%^ loading HelloWorld Bean ^%^"+helloWorld1.getMessage());
			
	}

}
