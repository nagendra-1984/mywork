package com.neoteric.it.jdbc.transaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionManagerDemo {
	
	public static void main(String[] args){
		
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("jdbcbeans.xml");
		CustomerManagerImpl customerManagerImpl = (CustomerManagerImpl)appContext.getBean("customerManager");
        Customer cust = createDummyCustomer();
        customerManagerImpl.createCustomer(cust);
        customerManagerImpl.getCustomer(4);
        appContext.close();
		
	}                                                                      
	
    private static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setId(4);
        customer.setName("Nagendra");
        Address address = new Address();
        address.setId(4);
        address.setCountry("United States");
        // setting value more than 20 chars, so that SQLException occurs
        address.setAddress("MALDEN MA");
        customer.setAddress(address);
        return customer;
    }
    
    
       
    
}
