<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload Example in JSP and Servlet - Java web application</title>
    </head>
 
    <body> 
        <div>
            <h3> Choose File to Upload in Server </h3>
            <form action="FileUpload" method="post" enctype="multipart/form-data">
                <input type="file" name="file1" />
                <input type="file" name="file2" />
                
                <input type="submit" name="action" value="upload" />
                <input type="submit" name="action" value="download" />
                
                <input type="hidden" name="FileName" value="HRQuestions.txt"/>
            Status :   <%=request.getAttribute("STATUS") %>
            </form>          
            
        </div>
      
    </body>
</html>
