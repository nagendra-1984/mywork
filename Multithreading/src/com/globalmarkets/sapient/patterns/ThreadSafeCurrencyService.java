package com.globalmarkets.sapient.patterns;

public class ThreadSafeCurrencyService {
	
	/*
	 *  Thread Safe - as the instance is loaded during class-load time. 
	 *  Also known as Early Initialization 
	 */
	private static volatile ThreadSafeCurrencyService _currencyService = new ThreadSafeCurrencyService();
	public static String strCurrenyObjId;
	
	/*
	 *  Class to load Cache, Need only one instance at any time
	 */

	private ThreadSafeCurrencyService (){
		
		strCurrenyObjId="firstObj";
	}
	
	/*
	 *  Simple way to return the Single Ton Class
	 */
	public static ThreadSafeCurrencyService getCurrServiceInstance(){
		// Generating instance of the class in the instance menthod.
		if(_currencyService == null){
			_currencyService = new ThreadSafeCurrencyService();
			strCurrenyObjId ="secondObj";
		}
		return _currencyService;
	}
	
	
	/**
	 * 
	 * @param strCountryCode
	 * @return strCurrency - Currency of the selected Country
	 */
	public String getCurrenyData(String strCountryCode){
		
		String strCurrency=null; 
		
		if(strCountryCode!=null && strCountryCode.equals("INDIA")){
			
			strCurrency= "RUPEE";
		}else if (strCountryCode!=null && strCountryCode.equals("USA")){
			strCurrency= "DOLLAR";
		}
				
		return strCurrency;
	}
}
