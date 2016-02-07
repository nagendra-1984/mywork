package com.neoteric.it.jdbc.transaction;

public interface CustomerManager {
	
	public void createCustomer(Customer customer);
	public Customer getCustomer(int id);

}
