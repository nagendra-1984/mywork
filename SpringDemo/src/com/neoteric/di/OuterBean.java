package com.neoteric.di;

public class OuterBean {

	public OuterBean(InnerBean innerBean){
		this.innerBean=innerBean;
	}
	
	//public OuterBean(){}
	
	private InnerBean innerBean;

	public InnerBean getInnerBean() {
		return innerBean;
	}

	public void setInnerBean(InnerBean innerBean) {
		this.innerBean = innerBean;
	}
	
	public void getOuterMessage(){
		
		System.out.println("^%^ Outer Bean Message ^%^");
	}
	
	public void getInnerMessage(){
		
		innerBean.getInnerMessage();
	}
	
}
