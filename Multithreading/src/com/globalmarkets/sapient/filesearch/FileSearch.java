package com.globalmarkets.sapient.filesearch;

import java.io.File;




public class FileSearch implements Runnable{
	
	private final String strFolderPath;
	private final String strFileName;
	
	FileSearch(String folderPath, String fileName){
		this.strFolderPath=folderPath;
		this.strFileName=fileName;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("^%^ Starting Thread ^%^"+Thread.currentThread().getName());
		File dirFile = new File(strFolderPath);
		searchFile(dirFile,strFileName);
		System.out.println("^%^ Finishing Thread ^%^"+Thread.currentThread().getName());
	}

	public void searchFile(File fileDirectory,String strFileName){
		System.out.println("^%^ Searching files under "+fileDirectory.getName());

		if(fileDirectory.exists()){
		
			File[] subFiles = fileDirectory.listFiles();
			
			for(File subFile : subFiles){
				if(subFile.isDirectory()){
					System.out.println("^%^ Directory Found ^%^"+subFile.getName());
					searchFile(subFile,strFileName);
					
				}else if(subFile.getName().contains(strFileName)){
					System.out.println("^%^ File Found at ^%^"+ subFile.getParent() +"^%^ File Name ^%^" + subFile.getName());
				}
			}
		
		}
	}
	
	
}
