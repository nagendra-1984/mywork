package com.neoteric;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class MessageJUnit {

	
	String strMessage = "Hello Word";
	MessageUtil messageUtil = new MessageUtil(strMessage);
	
	@Test
	public void testPrintMessage(){
		// use assertEquals method to perform the test
		assertEquals(strMessage,messageUtil.getStrMessage());
	}
	
	
}
