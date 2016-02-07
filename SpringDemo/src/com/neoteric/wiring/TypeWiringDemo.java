package com.neoteric.wiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TypeWiringDemo {
	
	public static void main(String args[]){
		
		System.out.println("^%^ AutoWiring by Type Demo ^%^");
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Beans.xml");
		Parent parentObj = (Parent)appContext.getBean("parentByType");
		System.out.println("&^& Parent Name ^%^"+parentObj.getParentName());
		System.out.println("&^& Child Name ^%^"+parentObj.getChild1().getChildName());
	}

}
