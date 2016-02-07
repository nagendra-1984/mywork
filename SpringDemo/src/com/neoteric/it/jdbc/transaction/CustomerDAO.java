package com.neoteric.it.jdbc.transaction;

public interface CustomerDAO {

	public void create(Customer customer);
	public Customer getCustomerList(int customerId);
}
