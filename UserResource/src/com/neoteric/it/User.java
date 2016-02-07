package com.neoteric.it;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String strName;
	private String strEmailId;
	private String strPhoneNumber;
	private int intSalary;
	private int intBonus;
	
	User(){}
	
	User(String strName,String strEmailId,String strPhoneNumber){
		
		this.strName = strName;
		this.strEmailId = strEmailId;
		this.strPhoneNumber = strPhoneNumber;
	}
	
	public String getStrName() {
		return strName;
	}
	
	@XmlElement
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrEmailId() {
		return strEmailId;
	}
	@XmlElement
	public void setStrEmailId(String strEmailId) {
		this.strEmailId = strEmailId;
	}
	public String getStrPhoneNumber() {
		return strPhoneNumber;
	}
	@XmlElement
	public void setStrPhoneNumber(String strPhoneNumber) {
		this.strPhoneNumber = strPhoneNumber;
	}
	
	public int getIntSalary() {
		return intSalary;
	}
	@XmlElement
	public void setIntSalary(int intSalary) {
		this.intSalary = intSalary;
	}
	public int getIntBonus() {
		return intBonus;
	}
	@XmlElement
	public void setIntBonus(int intBonus) {
		this.intBonus = intBonus;
	}

}
