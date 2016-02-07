package com.globalmarkets.sapient.compare;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("^%^ Demo of Comparator Util ^%^");
		PersonComparator personComparator = new PersonComparator();
		
		Person person1 = new Person(30,"Nagendra");
		Person person2 = new Person(28,"Swetha");
		Person person3 = new Person(60,"Subba Reddy");
		Person person4 = new Person(50,"Narayanamma");
		
		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
		
		
		/**
		 *  Sorting the List using Comparator
		 */
		Collections.sort(personList,personComparator);
		System.out.println("^%^ Ascending Order ^%^");
		for(Person person:personList){
			System.out.println("^%^ person ^%^"+person.getStrName());
		}
		
		/**
		 *  Sorting the List using Comparable Interface in the Person Object
		 */

		Collections.sort(personList);
		System.out.println("^%^ Descending Order ^%^");
		for(Person person:personList){
			System.out.println("^%^ person ^%^"+person.getStrName());
		}
	
	}

}
