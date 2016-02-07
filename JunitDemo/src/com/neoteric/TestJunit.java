package com.neoteric;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {

	@Test
	public void testAdd(){
		String str = "Junit Testing is fine";
		assertEquals("Junit Testing is lookinhg fine",str);
	}
		

}
