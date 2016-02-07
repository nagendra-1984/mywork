package com.globalmarkets.sapient.compare;

import java.util.HashMap;

public class HashMapImplDemo {
	
	public static void main(String args[]){
		
		System.out.println("^%^ Demo for HashMap Implementation using Person Class as Key^%^");
		
		Person firPerson = new Person(30,"Nagendra");
		Person secPerson = new Person(28,"Swetha");
		Person thirdPerson = new Person(2,"Kriyansh");
		
		
		HashMap<Person,String> familyMap = new HashMap<Person,String>();
		familyMap.put(firPerson, "Father");
		familyMap.put(secPerson, "Mother");
		familyMap.put(thirdPerson, "Kriyansh");
		
		
		
		System.out.println("^%^ Fetching the right Values using Person Object");
		
		Person searchPerson = new Person(2,"Kriyansh");
		
		System.out.println("^%^ Fetched Output ^%^"+familyMap.get(searchPerson));
		
		
	}

}
