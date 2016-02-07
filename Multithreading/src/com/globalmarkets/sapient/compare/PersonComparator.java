package com.globalmarkets.sapient.compare;

import java.util.Comparator;
import java.util.Map.Entry;

public class PersonComparator implements Comparator<Person>{

	@Override
	/**
	 * 
	 */
	public int compare(Person person1,Person person2) {
		// TODO Auto-generated method stub
		int age1 = person1.getAge();
		int age2	= person2.getAge();
		return age1 - age2;
	}

	
}
