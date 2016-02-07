package com.neoteric.aop;

public class CustomerImpl implements Customer{

	@Override
	public void browse() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("^%^ Browsing Internet^%^");
	}

	@Override
	public void watchVideo() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("^%^ Watching Video^%^");
	}

}
