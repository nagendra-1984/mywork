package com.globalmarkets.sapient.strings;

public class StringsUtilDemo {

	
	public static void main(String args[]){
		
		System.out.println("^%^ Strings Util Demo ^%^");
		
		// Created a new String literal and stores in String Pool
		String strABC="ABC";
		
		// Re-Uses the same literal available on the String Pool
		String strAltABC="ABC";
		
		// In this case, creates two objects , one new String Object and one String added to String Pool
		String strnewABC = new String("NewABC");
		
		Double doubleValue = Double.valueOf("0.0");
		
		System.out.println("^%^ double Value ^%^"+doubleValue);
		
		System.out.println("^%^ Reverse String ^%^"+reverseRecurrivesly("Happy is Mommy"));
		System.out.println("^%^ Reverse String ^%^"+reverse("Happy is Mommy"));
	}
	
	  public static String reverse(String str) {
	        StringBuilder strBuilder = new StringBuilder();
	        char[] strChars = str.toCharArray();

	        for (int i = strChars.length - 1; i >= 0; i--) {
	            strBuilder.append(strChars[i]);
	        }

	        return strBuilder.toString();
	    }


	
	
	public static String reverseRecurrivesly(String strPhrase){
		
		if(strPhrase.length()<2){
			return strPhrase;
		}else{
			
			return reverseRecurrivesly(strPhrase.substring(1))+strPhrase.charAt(0);
		}
	}
}
