package com.neoteric.wiring;

public class Parent {
	
	private Child child;
	private Child child1;
	
	public Parent (){
		System.out.println("^%^ Invoked default Constructor ^%^");
	}
	
	public Parent(Child child){
		System.out.println("^%^ Invoked child Constructor ^%^");
		this.child = child;
		
	}

	public Child getChild1() {
		return child1;
	}

	public void setChild1(Child child1) {
		this.child1 = child1;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
	
	public String getParentName(){
		
		return "Nagendra";
	}

}
