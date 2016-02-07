package com.globalmarkets.sapient.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreepMapDemo {
	
	public static void main(String args[]){
		
		System.out.println("^%^ Demo of TreeMap Implementation");

		HashMap<String,String> map = new HashMap<String,String>();
		map.put("6", "Farrot");
		map.put("6", "Aarrot");
		map.put("1", "Apple");
		map.put("2", "Dannana");
		map.put("3", "Carrot");
		

		// Default Natural Sorting using TreeMap 
		TreeMap<String,String> treeMap = new TreeMap<String,String>(map);
		
		Set<Entry<String,String>> sortedMapEntries = treeMap.entrySet();
		
		for(Entry<String,String> sortedEntry : sortedMapEntries){
			System.out.println("^^%^ Map Entries ^%^"+sortedEntry.getKey()+"_"+sortedEntry.getValue());;
		}
		
		
		// Can have Custom Sorting using Overloaded Constructor of TreeMap 
		// Note the TreeMap overloaded constructor uses Comparator only on keys not on values
		
		NumberComparator numberComparator = new NumberComparator();
		TreeMap<String,String> sortedTreeMap= new TreeMap<String,String>(numberComparator);
		
		sortedTreeMap.put("Nag", "1");
		sortedTreeMap.putAll(map);
		
		
		Set<Entry<String,String>> sortedEntries = sortedTreeMap.entrySet();
		
		for(Entry<String,String> sortedEntry : sortedEntries){
			System.out.println("^^%^ Entries ^%^"+sortedEntry.getKey()+"_"+sortedEntry.getValue());;
		}
		
	
		// Sorting using Comparator in TreeSet 
		TreeSet<String> treeSet = new TreeSet<String>(numberComparator);
		treeSet.add("T");
		treeSet.add("M");
		treeSet.add("t");
		treeSet.add("m");
		
			
		Iterator<String> treeSetEntries= treeSet.iterator();
		while(treeSetEntries.hasNext()){
			
			System.out.println("^%^Elements___^%^"+treeSetEntries.next());
		}
		

	
	}
	
	

}
