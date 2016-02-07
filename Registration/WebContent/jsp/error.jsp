<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- JSP Declaration  Initializing  variables --> 

<%! int day = 3; %> 
<%@ page errorPage="/jsp/error.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<form method="POST" action="/Registration/UserServlet">
													
	
	<table>
	<jsp:forward page="/jsp/welcome.jsp"></jsp:forward>
		<tbody>
		<jsp:useBean id="user" class="com.neoteric.it.vo.UserVO"/>
		
		User Name : <jsp:getProperty property="user" name="strUserName"/>
		Password : <jsp:getProperty property="user" name="strPwd"/>		
	<% out.print("Hellp");%>
		
		</tbody>
	</table>
	
	</form>
</body>
</html>