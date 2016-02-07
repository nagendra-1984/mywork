package com.neoteric.it.vo;

public class UserVO {

	   private String message = "No message specified";
	   private String strUserName;
	   private String strPwd;
	   
	   public String getMessage() {
	      return(message);
	   }
	   public void setMessage(String message) {
	      this.message = message;
	   }
	public String getStrUserName() {
		return strUserName;
	}
	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}
	public String getStrPwd() {
		return strPwd;
	}
	public void setStrPwd(String strPwd) {
		this.strPwd = strPwd;
	}
}
