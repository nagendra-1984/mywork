package com.globalmarkets.sapient.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HashMapDemo {
	
	public static void main(String args[])
	{
		System.out.println("^%^ Demo of HashSet Implementation");

		HashMap<String,String> map = new HashMap<String,String>();
		map.put("1", "Apple");
		map.put("2", "Dannana");
		map.put("3", "Carrot");
		map.put("6", "Farrot");
		map.put("7", "Aarrot");
		
		//fetchKeys(map);
		//fetchValues(map);
		//naturalSortMap(map);
		sortValueMap(map);

		
	}
	
	/**
	 * 
	 * @param map
	 */
	public static void fetchKeys(HashMap<String,String> map){
		
		/*
		 *  Process to retrieve the elements using Set
		 */
		
		Set<String> keySet= map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator!=null && keyIterator.hasNext()){
			System.out.println("^%^ printing keys ^%^"+keyIterator.next());
		}
		
	}
	
	/**
	 * 
	 * @param map
	 */
	public static void fetchValues(HashMap<String,String> map){
		
		/*
		 *  Process to retrieve the values using Collections
		 */
		
		Collection<String> valueCollections= map.values();
		
		for(String value: valueCollections){
			
			System.out.println("^%^ Value ^%^"+value);
		}
		
	}
	
	
	/**
	 * 
	 * @param map
	 */
	public static void naturalSortMap(HashMap<String,String> map){
		
		/**
		 *  To generate the Sorted Map using TreeMap
		 */
		
			TreeMap<String,String> treeMap = new TreeMap<String,String>(map);
			
			System.out.println("^%^ Converting HashMap in sorting order by using TreeMap");
			
			Set<Entry<String, String>> treeSet = treeMap.entrySet();
			Iterator<Entry<String,String>> treeSetIterator = treeSet.iterator();
			
			while(treeSetIterator.hasNext()){
				Entry<String,String> treeEntry = treeSetIterator.next();
				System.out.println("^%^ Key ^%^"+treeEntry.getKey());
				System.out.println("^%^ Value ^%^"+treeEntry.getValue());
			}
			
	}
	
	/**
	 * 
	 * @param map
	 */
	public static void sortKeyMap(HashMap<String,String> map){
		
		/**
		 *  Generate Map by sorting keys of an Map, this is acheived by using TreeMap
		 */
				
		TreeMap<String,String> treeMap = new TreeMap<String,String>(map);
		
		System.out.println("^%^ Converting HashMap in sorting order by using TreeMap");
		
		Set<Entry<String, String>> treeSet = treeMap.entrySet();
		for(Entry<String,String> entry : treeSet){
			System.out.println("^%^ Key ^%^ "+entry.getKey()+"^%^ Value ^%^"+entry.getValue());
		}
	
	}
	
	
	/**
	 * 
	 * @param map
	 */
	public static void sortValueMap(HashMap<String,String> map){
		
		/**
		 *  Generate list by sorting Values of an Map, this is acheived by using Custom Comparator
			Getting ValueComparator instance
		 */
				
		ValueComparator valueComparator = new ValueComparator();
		
		List<Entry<String,String>> entryList = new ArrayList<Entry<String,String>>(map.entrySet());
		Collections.sort(entryList, valueComparator);
		LinkedHashMap<String,String> sortedLinkedMap= new LinkedHashMap<String,String>(entryList.size());
		
		for(Entry<String,String> valueEntry : entryList){
			System.out.println("^%^ Key ^%^ "+valueEntry.getKey()+"^%^ Value ^%^"+valueEntry.getValue());
			sortedLinkedMap.put(valueEntry.getKey(), valueEntry.getValue());
		}
		
		/**
		 *   Copy data from Linked Has Map to HashMap
		 */
	
		Set<Entry<String,String>> entriesSortedByValue = sortedLinkedMap.entrySet();
		for(Entry<String,String> sortedValueEntry: entriesSortedByValue){
			System.out.println("^% Key ^%^"+ sortedValueEntry.getKey() + "^%^ Value ^%^"+sortedValueEntry.getValue());
			
		}
		
	}
	
	
}
