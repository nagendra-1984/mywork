package com.neoteric.di;

public class InnerBean {
	
	public String getInnerMessage(){
		
		System.out.println("^%^ Inner Message^%^");
		
		return "Inner Bean Message";
	}

}
