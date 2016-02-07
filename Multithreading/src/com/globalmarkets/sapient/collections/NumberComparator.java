package com.globalmarkets.sapient.collections;

import java.util.Comparator;
import java.util.Map.Entry;

public class NumberComparator implements Comparator<String>{

	@Override
	/**
	 * 
	 */
	public int compare(String entry1,String entry2) {
		// TODO Auto-generated method stub
		return entry1.compareToIgnoreCase(entry2);
	}

}
