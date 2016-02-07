package com.globalmarkets.sapient.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class PeopleMap {
	
	private static ConcurrentHashMap<String,String> concurrentMap = null;
	private static HashMap<String,String> synchronizedMap =null;
	private static HashMap<String,String> regularMap=null;
	
	PeopleMap(){
		
		concurrentMap = new ConcurrentHashMap<String,String>();
	
		concurrentMap.put("1", "Apple");
		concurrentMap.put("2", "Dannana");
		concurrentMap.put("3", "Carrot");
		concurrentMap.put("6", "Farrot");
		concurrentMap.put("7", "Aarrot");
			
		synchronizedMap= new HashMap<String,String>();
		synchronizedMap.put("1", "synchronizedMapApple");
		synchronizedMap.put("2", "synchronizedMapDannana");
		synchronizedMap.put("3", "synchronizedMapCarrot");
		synchronizedMap.put("6", "synchronizedMapFarrot");
		synchronizedMap.put("7", "synchronizedMapAarrot");
		Collections.synchronizedMap(synchronizedMap);
		

		regularMap = new HashMap<String,String>();
		
		regularMap.put("1", "Apple");
		regularMap.put("2", "Dannana");

		
	}
	
	/**
	 * 
	 * @return
	 */
	public ConcurrentHashMap<String,String> getPeopleMap(){
		return this.concurrentMap;
	}

	/**
	 * 
	 */
	public void setPeopleMap(ConcurrentHashMap<String,String> pMap){
		
		this.concurrentMap = pMap;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public HashMap<String,String> getSynchronizedPeopleMap(){
		return this.synchronizedMap;
	}

	/**
	 * 
	 */
	public void setSynchronizedPeopleMap(HashMap<String,String> pMap){
		System.out.println("^%^ Synchronized Map after Adding Values ^%^"+pMap);
		this.synchronizedMap = pMap;
	}
	
	/**
	 * 
	 * @return
	 */
	public HashMap<String,String> getRegularPeopleMap(){
		return this.regularMap;
	}

	/**
	 * 
	 */
	public void setRegularPeopleMap(HashMap<String,String> pMap){
		
		this.regularMap = pMap;
	}
}
