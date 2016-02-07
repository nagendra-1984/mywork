package com.neoteric.it.jdbc.transaction;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CustomerManagerImpl implements CustomerManager{

	 private CustomerDAO customerDAO;
	
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.create(customer);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.MANDATORY)
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerList(id);
	}

	
}
