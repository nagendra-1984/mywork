package com.neoteric.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.neoteric.di.InnerBean;

public class SpringCollection {
	
	public List getAddressList() {
		return addressList;
	}
	public void setAddressList(List addressList) {
		this.addressList = addressList;
	}
	public Set getAddressSet() {
		return addressSet;
	}
	public void setAddressSet(Set addressSet) {
		this.addressSet = addressSet;
	}
	public Map getAddressMap() {
		return addressMap;
	}
	public void setAddressMap(Map addressMap) {
		this.addressMap = addressMap;
	}
	public Properties getAddressProperties() {
		return addressProperties;
	}
	public void setAddressProperties(Properties addressProperties) {
		this.addressProperties = addressProperties;
	}
	
	
	public List<InnerBean> getInnerBeanList() {
		return innerBeanList;
	}
	public void setInnerBeanList(List<InnerBean> innerBeanList) {
		this.innerBeanList = innerBeanList;
	}


	private List addressList;
	private Set addressSet;
	private Map addressMap;
	private Properties addressProperties;
	private List<InnerBean> innerBeanList;

}
