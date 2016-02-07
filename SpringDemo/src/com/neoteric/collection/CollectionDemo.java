package com.neoteric.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neoteric.di.InnerBean;

public class CollectionDemo {

	private static List<String> addressList;
	private static Set<String> addressSet;
	
	public static void main(String args[]){
		
		System.out.println("^%^ Collection Demo ^%^");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Beans.xml");
		SpringCollection collectionDemo = (SpringCollection)appContext.getBean("collectionDemo");
		addressList = collectionDemo.getAddressList();
		for(String address :addressList){
			
			System.out.println("^%^ Addresses ^%^"+address);
		}
		addressSet = collectionDemo.getAddressSet();
		for(String address :addressSet){
			
			System.out.println("^%^ Set Addresses ^%^"+address);
		}
		System.out.println("^%^ HashMap Properties ^%^"+collectionDemo.getAddressMap());
		System.out.println("^%^ Properties ^%^"+collectionDemo.getAddressProperties());
		List<InnerBean> innerBeanList = (List<InnerBean>)collectionDemo.getInnerBeanList();
		for(InnerBean innerBean:innerBeanList){
			System.out.println("^%^ InnerBean Message^%^"+innerBean.getInnerMessage());
		}
		
		
		
		
	}
}
