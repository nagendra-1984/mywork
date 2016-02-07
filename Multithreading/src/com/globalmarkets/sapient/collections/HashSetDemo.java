package com.globalmarkets.sapient.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashSetDemo {
	
	public static void main(String args[]){
		
		System.out.println("^%^ Demo of HashSet Implementation");

		List<String> numberList = new ArrayList<String>();
		numberList.add("1");
		numberList.add("2");
		numberList.add("3");
		
		
		HashSet<String> listSet = new HashSet<String>(numberList);
		
		HashSet<String> set = new HashSet<String>();
		set.add("one");
		set.add("two");
		set.add("three");
		
		
		/*
		 *  Process to retrieve the elements using interator
		 */
		
		Iterator<String> setIter= set.iterator();
		while(setIter.hasNext()){
			
			System.out.println("^%^Elements___^%^"+setIter.next());
		}
		
		Iterator<String> listIter= listSet.iterator();
		while(listIter.hasNext()){
			
			System.out.println("^%^Elements___^%^"+listIter.next());
		}
	
	}

}
