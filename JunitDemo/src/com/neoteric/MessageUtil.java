package com.neoteric;


public class MessageUtil {
	
	 private String strMessage;
	 
	 MessageUtil(String strMessage){
		 this.strMessage = strMessage;
	 }

	public String getStrMessage() {
		return strMessage;
	}

	public void setStrMessage(String strMessage) {
		System.out.println(strMessage);
		this.strMessage = strMessage;
	}
	

	public String printMessage(){
		System.out.println(strMessage);
		return strMessage;
		
	}

}
