package com.neoteric.aop;

public class CafeOwner {

	
	public void loginTime(){
		System.out.println("^%^ Customer Logged in Time %^");
		
	}
	
	public void loggedOutTime(){
		
		System.out.println("^%^ Customer Logged Out Time^%^");
	}
	
	public void usageBill(){
		System.out.println("^%^Calculate and provide Bill");
		
	}
	
	public void cancelBilling(){
		
		System.out.println("^%^Cancel Billing ^%^");
	}
}
