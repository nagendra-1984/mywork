package com.globalmarkets.sapient.patterns;

public class CurrencyService {
	
	/*
	 *  Not Thread Safe - 
	 * 
	 */
	private static CurrencyService _currencyService = null;
	
	/*
	 *  Class to load Cache, Need only one instance at any time
	 */

	private CurrencyService (){
		
	}
	
	/**
	 * 
	 * @return CurrencyService Instance
	 */
	public static CurrencyService getCurrServiceInstance(){
		// Generating instance of the class in the instance menthod.
		/*
		 *  Prone to Threading Issue , as two threads may enter this method, one thread can get the instance , another thread does not the status.
		 *  
		 *  
		 *  
		 */
		if(_currencyService == null){
			_currencyService = new CurrencyService();
		}
		
		/*
		 *  To solve the problem use the Synchronized Block on CurrenyService Class to avoid the issue
		 */
		
		if(_currencyService == null){
			
			synchronized(CurrencyService.class){
					if(_currencyService == null){
						_currencyService = new CurrencyService();
					}
			}
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
