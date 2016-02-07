package com.neoteric.wiring;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventHandlingDemo {
	
	public static void main(String args[]){
		
		System.out.println("^%^ Demo for Event Handling ^%^");
		
		ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("Beans.xml");
		
		appContext.start();
		
		Parent parentObj = (Parent)appContext.getBean("parentByCons");
		System.out.println("&^& Parent Name ^%^"+parentObj.getParentName());
		
		appContext.stop();

		
	}

}
