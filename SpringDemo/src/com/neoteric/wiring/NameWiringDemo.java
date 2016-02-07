package com.neoteric.wiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NameWiringDemo {
	
	public static void main(String args[]){
		
		System.out.println("^%^ AutoWiring by Name Demo ^%^");
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Beans.xml");
		Parent parentObj = (Parent)appContext.getBean("parentByName");
		
		System.out.println("&^& Parent Name ^%^"+parentObj.getParentName());
		System.out.println("&^& Child Name ^%^"+parentObj.getChild().getChildName());
	}

}
