package com.neoteric.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InternetCafeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("^%^ Demo for AOP Program ^%^");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("AOPBeans.xml");
		
		Customer customer = (Customer)appContext.getBean("customerProxy");
		try {
			customer.browse();
			//customer.watchVideo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
