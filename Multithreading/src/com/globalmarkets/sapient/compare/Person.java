package com.globalmarkets.sapient.compare;

public class Person implements Comparable<Person>{
	
	public int hashCode(){
		System.out.println("^%^ Generated Hash Code ^%^"+age*2015*(strName.length()));
		return age*2015*(strName.length());
		
	
	}
	

	public boolean equals(Object obj){
		System.out.println("^%^ entering Equals Method ^%^");
		
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		
		Person perObj = (Person)obj;
		
		if(perObj != null && 
				this.age == perObj.getAge() && this.strName.equals(perObj.getStrName()))
			{return true;}
		else {
				return false;
			}
	}
	
	Person(int age, String strName){
		this.age=age;
		this.strName=strName;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	private int age;
	private String strName;
	
	
	@Override
	public int compareTo(Person person) {
		// TODO Auto-generated method stub
		return person.getAge()-this.getAge();
	}
	
}
