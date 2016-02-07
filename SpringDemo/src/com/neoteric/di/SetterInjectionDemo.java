package com.neoteric.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionDemo {

	
	public static void main(String args[]){
		
		System.out.println("^%^ SetterInjection Demo ^%^");
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Beans.xml");
		OuterBean outerBean = (OuterBean)appContext.getBean("outerBean");
		outerBean.getOuterMessage();
		outerBean.getInnerMessage();
	}
}
