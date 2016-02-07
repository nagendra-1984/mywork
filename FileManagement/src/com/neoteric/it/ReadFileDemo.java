package com.neoteric.it;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileDemo {

	public static void main (String args[]) throws IOException{
		try{
		System.out.println("^%^ Read File Sample ^%^");
		FileInputStream fileInput = new FileInputStream("C:\\work\\Output.txt");
		System.out.println("^%^ Reading File using File Input Stream ^%^");
		
		byte[] b = new byte[1024];
		int read = 1;
		while((read = fileInput.read(b))!=-1){
			
		}
		
		FileReader fileRead = new FileReader("C:\\work\\Output.txt");
		
		BufferedReader bufferReader = new BufferedReader(fileRead);
		String line = bufferReader.readLine();
		while(line != null)
		{
		  System.out.println(line);
		  line = bufferReader.readLine();
		}
		
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		InputStream input = new BufferedInputStream(new FileInputStream("C:\\work\\Output.txt"));
		byte[] buffer = new byte[8192];

		try {
		    for (int length = 0; (length = input.read(buffer)) != -1;) {
		    	System.out.println(length);
		        System.out.write(buffer, 0, length);
		    }
		} finally {
		    input.close();
		}
	}
}
