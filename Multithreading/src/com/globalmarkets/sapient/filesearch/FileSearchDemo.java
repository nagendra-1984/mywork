package com.globalmarkets.sapient.filesearch;

public class FileSearchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("^%^ Demo of File Search using two Threads^%^");
		
			System.out.println("^%^ Current Thread ^%^"+Thread.currentThread().getName());
			
			FileSearch fileSearch1 = new FileSearch("C:\\Users\\ssweth\\Desktop\\Learning","questions");
			FileSearch fileSearch2 = new FileSearch("C:\\Users\\ssweth\\Downloads","questions");
			
			Thread t1 = new Thread(fileSearch1);
			Thread t2 = new Thread(fileSearch2);
			
			t1.start();
			t2.start();	
			
			
	
	}

}
