package com.globalmarkets.sapient.patterns;

public class SingleTonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strCurrencyCode ;
		System.out.println("^%^Demo Class for Verifying SingleTon Pattern");

		ThreadSafeCurrencyService _firCurrencyService= ThreadSafeCurrencyService.getCurrServiceInstance();
		System.out.println("^%^ fir currency Obj Id ^%^"+_firCurrencyService.strCurrenyObjId);
		
		ThreadSafeCurrencyService _secCurrencyService= ThreadSafeCurrencyService.getCurrServiceInstance();
		System.out.println("^%^ sec currency Obj Id ^%^"+_secCurrencyService.strCurrenyObjId);
		
		strCurrencyCode =_firCurrencyService.getCurrenyData("INDIA");
		System.out.println("^%^ currency Code ^%^"+strCurrencyCode);
		
	}

}
