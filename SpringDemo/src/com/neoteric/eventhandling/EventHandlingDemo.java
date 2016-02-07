package com.neoteric.eventhandling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventHandlingDemo {
	
	public static void main(String args[]){
		
		System.out.println("^%^ AutoWiring by Type Demo ^%^");
		
		ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("Beans.xml");
		
		appContext.start();
		
		appContext.stop();
	}

}
