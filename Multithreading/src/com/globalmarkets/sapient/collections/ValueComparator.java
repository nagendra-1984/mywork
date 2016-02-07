package com.globalmarkets.sapient.collections;

import java.util.Comparator;
import java.util.Map.Entry;

public class ValueComparator implements Comparator<Entry<String,String>>{

	@Override
	/**
	 * 
	 */
	public int compare(Entry<String,String> entry1,Entry<String,String> entry2) {
		// TODO Auto-generated method stub
		String strValue1 = entry1.getValue();
		String strValue2	= entry2.getValue();
		return strValue1.compareTo(strValue2);
	}

}
