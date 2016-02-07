package com.neoteric.it.jdbc.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet resSet, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setId(resSet.getInt("id"));
		customer.setName(resSet.getString("name"));
		return customer;
	}
	
	

}
