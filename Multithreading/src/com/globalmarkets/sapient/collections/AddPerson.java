package com.globalmarkets.sapient.collections;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AddPerson implements Runnable{
	PeopleMap peopleMapObj = new PeopleMap();
	ConcurrentHashMap<String,String> concurrentMap = new ConcurrentHashMap<String,String>();
	HashMap<String,String> synchronizedMap = null;
	HashMap<String,String> regularMap = null;
	
	public void run(){

		
			System.out.println(" Adding People TO People Map ");
			concurrentMap = (ConcurrentHashMap<String, String>) peopleMapObj.getPeopleMap();
			concurrentMap.put("9", "Elephant");
			peopleMapObj.setPeopleMap(concurrentMap);
			
			synchronizedMap = (HashMap<String, String>) peopleMapObj.getSynchronizedPeopleMap();
			System.out.println("^%^ Synchronised Hash Map ^%^"+synchronizedMap);
			synchronizedMap.put("9", "SynchronizedElephant");
			peopleMapObj.setSynchronizedPeopleMap(synchronizedMap);
			
			
			regularMap = (HashMap<String, String>) peopleMapObj.getRegularPeopleMap();
			synchronized(regularMap){
				System.out.println("^%^ Entering Synchronized Block to Add Entry to Regular Map ^%^");
				regularMap.put("9", "regularElephant");
				peopleMapObj.setRegularPeopleMap(regularMap);
			}
	}
	
}
