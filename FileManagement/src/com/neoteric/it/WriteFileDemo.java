package com.neoteric.it;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		
			System.out.println("^%^ WriteFileDemo ^%^");
			FileOutputStream fileOut = new FileOutputStream("C:\\work\\Output.txt");
			FileWriter fileWrite = new FileWriter("C:\\work\\Output_File.txt");
			String fileText = "Hello File Application";
			fileOut.write(fileText.getBytes());
			fileWrite.write(fileText);
			fileOut.close();
			fileWrite.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}
