package com.neoteric.it;

import java.util.Set;

public class Employee {

	private int id;
	   private String firstName; 
	   private String lastName;   
	   private int salary; 
	   private Address address;
	   private Set<Certificate> certificate;
	   private Set<Certificate> empCertificate;
	   

	public Employee() {}
	
	public Employee(String fname, String lname, int salary, Address address) {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.salary = salary;
	      this.address = address;
	   }
	
	public Employee(String fname, String lname, int salary, Address address,Set certSet) {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.salary = salary;
	      this.address = address;
	      this.certificate = certSet;
	   }
	   
	public Employee(String fname, String lname, int salary) {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.salary = salary;
	      
	   }
	   
	
	   public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Certificate> getCertificate() {
		return certificate;
	}

	public void setCertificate(Set<Certificate> certificate) {
		this.certificate = certificate;
	}

	public Set<Certificate> getEmpCertificate() {
		return empCertificate;
	}

	public void setEmpCertificate(Set<Certificate> empCertificate) {
		this.empCertificate = empCertificate;
	}
	
}
