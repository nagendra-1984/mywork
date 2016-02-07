package com.neoteric;

public class HelloWorld {
	   private String message;
	   private int instanceCount=0;
	   
	   HelloWorld(){
		   this.instanceCount = this.instanceCount+1;
	   }
	   
	   public void init(){
		   System.out.println("^%^ Initialing the Bean ^%^");
		   this.message="Initializing the Bean";
		   
	   }
	   
	   public void destroy(){
		   System.out.println("^%^ destroying the bean ^%^");
		   		   
	   }

	   public void setMessage(String message){
	      this.message  = message;
	   }

	   public String getMessage(){
	      System.out.println("Your Message : " + message);
	      return "Your Message"+message+this.instanceCount;
	   }
	}
