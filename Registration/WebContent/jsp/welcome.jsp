<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- JSP Declaration  Initializing  variables --> 


<%@ page errorPage="/jsp/error.jsp" %>
<%@ page import="" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome </title>
</head>
<body>
<form method="POST" action="/Registration/UserServlet">
	
 Today's date: <%= (new java.util.Date()).toLocaleString()%>
 <%! int day = 1; %> 
<% if (day == 1 | day == 7) { %>
      <p> Today is weekend</p>
<% } else { %>
      <p> Today is not weekend</p>
<% } %>
	
	<% out.println(config.getInitParameter("CompanyName")); %>
	<% out.println(config.getInitParameter("Country")); %>
	
	
Company Name : <% config.getInitParameter("CompanyName"); %>
Country : 	<% config.getInitParameter("Country"); %>
	<table>
	
		<tbody>
		
			<tr>
			<td colspan="2"><input type="submit" name="useraction" value="createuser"/> 
					</td>
			</tr>
			
			<tr>
			<td colspan="2"><input type="submit" name="useraction" value="editUser"/>
			</td>
			</tr>
			
						
		</tbody>
	</table>
	<input type="hidden" name="myParam" value="blockTheRequest"/>
	</form>
</body>
</html>