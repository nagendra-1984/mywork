package com.neoteric.it.jdbc.transaction;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class CustomerDAOImpl implements CustomerDAO{
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Customer customer) {
		// TODO Auto-generated method stub
	     String queryCustomer = "insert into Customer (id, name) values (?,?)";
	     String queryAddress = "insert into Address (id, address,country) values (?,?,?)";
	     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	     
	     //jdbcTemplate.update(queryCustomer,new Object[]{customer.getId(),customer.getName()});
	     jdbcTemplate.update(queryCustomer, customer.getId(),customer.getName());
	     
	        System.out.println("Inserted into Customer Table Successfully");
	     //jdbcTemplate.update(queryAddress, new Object[] { customer.getId(), customer.getAddress().getAddress(), customer.getAddress().getCountry() });
	     jdbcTemplate.update(queryAddress, customer.getId(),customer.getAddress().getAddress(),customer.getAddress().getCountry());
	     System.out.println("Inserted into Address Table Successfully");

	}

	@Override
	public Customer getCustomerList(int customerId) {
		// TODO Auto-generated method stub
		String selCustomerQuery="select * from Customer where id =?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Customer customer = jdbcTemplate.queryForObject(selCustomerQuery,new Object[]{customerId},new CustomerMapper());
		System.out.println("^%^ Customer Obj ^%^"+customer.getId()+"^%^ Name ^%^"+customer.getName());
		return customer;
	}

}
