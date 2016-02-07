package com.neoteric.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjectionDemo {
	
	public static void main(String args[]){
		
		System.out.println("^%^ Injecting using Constructor references");
		
		ApplicationContext appContext =  new ClassPathXmlApplicationContext("Beans.xml");
		OuterBean outerBean=(OuterBean)appContext.getBean("consOuterBean");
		System.out.println("^%^ Constructor Injection ^%^"+outerBean.getInnerBean().getInnerMessage());
	
	}

}
