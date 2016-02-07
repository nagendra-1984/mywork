package com.neoteric.it;

public class MathOperations {

	
	public String getSum(){
		
		return "SUM";
	}
	
	public String getDifference(){
		
		return "DIFF";
	}
	
	public int getProduct(PremiumVO premiumVO){
		
		return premiumVO.getPrincipal()*premiumVO.getInterest();
	}
	
}
