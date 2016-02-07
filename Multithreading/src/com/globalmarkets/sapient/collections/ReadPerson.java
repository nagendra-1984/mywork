package com.globalmarkets.sapient.collections;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ReadPerson implements Runnable{
	PeopleMap peopleMapObj = new PeopleMap();
	ConcurrentHashMap<String,String> concurrentMap = null;
	HashMap<String,String> synchronizedMap = null;
	HashMap<String,String> regularMap = null;
	
	
	
	public void run(){
		
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(" Reading People From People Map ");
			concurrentMap = (ConcurrentHashMap<String, String>) peopleMapObj.getPeopleMap();
			Set<Entry<String,String>> pSet = concurrentMap.entrySet();
			
			for(Entry peopleEntry: pSet){
				System.out.println("^%^ Value ^%^"+peopleEntry.getValue());
			}
			
			synchronizedMap = (HashMap<String, String>) peopleMapObj.getSynchronizedPeopleMap();
			System.out.println("^%^ synchronized Map Reading Values ^%^"+synchronizedMap);
			Set<Entry<String,String>> syncPeoSet = synchronizedMap.entrySet();
			
			for(Entry peopleEntry: syncPeoSet){
				System.out.println("^%^ Sync Value ^%^"+peopleEntry.getValue());
			}
			
			regularMap = (HashMap<String,String>)peopleMapObj.getRegularPeopleMap();
			
			synchronized(regularMap){
				
				System.out.println("^%^ Entering Synchronized Block to read HashMap ^%^");
				
				Set<Entry<String,String>> regPeoSet = regularMap.entrySet();
				
				for(Entry peopleEntry: regPeoSet){
					System.out.println("^%^ Reg Value ^%^"+peopleEntry.getValue());
				}
			
			}
			
	}
	
}
