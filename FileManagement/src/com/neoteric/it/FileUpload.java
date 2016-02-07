package com.neoteric.it;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.BorderUIResource.EmptyBorderUIResource;

import org.apache.activemq.protobuf.BufferInputStream;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * Servlet implementation class FileUpload
 */
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServletFileUpload servletFileUpload;  
    String downloadFolder = "C:\\work\\output";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(){
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File targetFolder = new File(downloadFolder);
		fileFactory.setRepository(targetFolder);
		servletFileUpload = new ServletFileUpload();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("^%^ Servlet Context ^%^"+request.getContextPath());
		request.getRequestDispatcher("/FileUpload.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String downloadFolder ="C:\\work\\output";
		String strAction = "download";
		System.out.println("^%^ Request Parameter Value %%^"+request.getParameter("action"));
		Enumeration paramNames = request.getAttributeNames();
		
		
		
		while(paramNames.hasMoreElements()){
			System.out.println("^&^ param Name ^%^"+(String)paramNames.nextElement());
		}
		
		if(strAction.equals("download")){
			try {
				download(request,response,downloadFolder);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(strAction.equals("upload")){
			try {
				upload(request,response,downloadFolder);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
   
	}

	
	private void upload(HttpServletRequest request,HttpServletResponse response,String downloadFolder) throws Exception{
		
		try{
			// Identifying is the Request is MultiPart request or Not using Apache file upload jar Class ServletFIleUpload
			if(ServletFileUpload.isMultipartContent(request)){
					
				// Using DiskFileItemFactory class
				DiskFileItemFactory fileFactory = new DiskFileItemFactory();
				ServletFileUpload fileUpload = new ServletFileUpload(fileFactory);
				List<FileItem> multiparts = fileUpload.parseRequest(request);
				File file;
				for(FileItem fileItem : multiparts){
					
					file = new File(fileItem.getName());
					System.out.println("&^& file Name "+file.getName());
					System.out.println("&^&  Canonical Path ^%^"+file.getCanonicalPath());
					System.out.println("&^&  Absolute Path ^%^"+file.getAbsolutePath());
						
					FileOutputStream outStream = new FileOutputStream(downloadFolder+"\\"+file.getName());
					outStream.write(fileItem.get());
					outStream.close();
				}
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}            
        request.setAttribute("STATUS", "File Uploaded Successfully");
		request.getRequestDispatcher("/FileUpload.jsp").forward(request, response); 		

	}
	
	private void download(HttpServletRequest request,HttpServletResponse response,String downloadFolder) throws Exception{
		String strFileName;
		
		try{
			// Identifying is the Request is MultiPart request or Not using Apache file upload jar Class ServletFIleUpload
		
				strFileName = "HRQuestions.txt";
				File downloadFile = new File (downloadFolder+"\\"+strFileName);
				FileInputStream fileInputStream = new FileInputStream(downloadFolder+"\\"+strFileName);
				ServletContext ctx = getServletContext();
				if(downloadFile.exists()){
					String mimeType = ctx.getMimeType(downloadFile.getAbsolutePath());
					response.setContentType(mimeType!=null?mimeType:"application/octet-stream");
					response.setContentLength((int)downloadFile.length());
					response.setHeader("Content-Disposition", "attachment; filename=\"" + strFileName + "\"");
					response.setHeader("Expires", "0");
				    response.setHeader("Cache-Control","must-revalidate, post-check=0,precheck=0");
				    response.setHeader("Pragma", "public");
				        
					OutputStream outStream = response.getOutputStream();
				
					/*
					ServletOutputStream outStream = response.getOutputStream();
					byte[] bufferData = new byte[1024];
					int read =0;
					while((read = fileInputStream.read(bufferData))!=-1){
						
						outStream.write(bufferData,0,read);
					}*/
					
								
					byte[] bufferData = new byte[1024];
					int read =0;
					// Reads all the byte from the file input stream to Byte Array
					
					
					while((read = fileInputStream.read(bufferData))!=-1){
						
						System.out.println("^%^ the byte Length ^%^"+bufferData.length);
						outStream.write(bufferData,0,read);
					}
					
					outStream.flush();
					outStream.close();
					fileInputStream.close();
					System.out.println("^%^ File Uploaded from client Successfully");
				}
				
        //request.setAttribute("STATUS", "File downloaded Successfully");
		//request.getRequestDispatcher("/FileUpload.jsp").forward(request, response); 		
	
	}catch(Exception ex){
		ex.printStackTrace();
	}

	}

}